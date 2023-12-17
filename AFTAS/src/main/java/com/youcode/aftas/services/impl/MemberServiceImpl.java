package com.youcode.aftas.services.impl;

import com.youcode.aftas.dto.req.MemberReq;
import com.youcode.aftas.dto.resp.MemberResp;
import com.youcode.aftas.entities.Member;
import com.youcode.aftas.repositorys.MemberRepository;
import com.youcode.aftas.services.interfaces.GenericService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MemberServiceImpl implements GenericService<Integer, MemberResp, MemberReq> {

 @Autowired
 private final MemberRepository repository;
 @Autowired
 private final ModelMapper modelMapper;


 public MemberServiceImpl(MemberRepository memberRepository,ModelMapper modelMapper){
     this.repository=memberRepository;
     this.modelMapper=modelMapper;
 }

    @Override
    public List<MemberResp> redAll() {
     List<Member>memberList=repository.findAll();
        List<MemberResp> memberRespList =memberList.stream().map(member -> modelMapper.map(member,MemberResp.class)).toList();
        return memberRespList ;
    }

    @Override
    public MemberResp getOne(Integer Id) {
        return null;
    }

    @Override
    public MemberResp create(MemberReq Q) {
     Member member=modelMapper.map(Q,Member.class);
     Member member1= repository.save(member);
     MemberResp memberResp=modelMapper.map(member1,MemberResp.class);
        return memberResp;
    }

    @Override
    public MemberResp update(MemberReq memberReq) {
     Member member=repository.getReferenceById(memberReq.getNum());
     if (member!=null){
//         TypeMap<MemberResp, Member> typeMap = modelMapper.createTypeMap(MemberResp.class, Member.class);
//         typeMap.addMappings(mapping -> mapping.skip(Member::setNum));
         modelMapper.map(memberReq,member);
         repository.save(member);
         return modelMapper.map(member, MemberResp.class);
     }
        return null;
    }

    @Override()
    public boolean delete(Integer num) {

        try {
            Member member=repository.getReferenceById(num);
            repository.delete(member);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
