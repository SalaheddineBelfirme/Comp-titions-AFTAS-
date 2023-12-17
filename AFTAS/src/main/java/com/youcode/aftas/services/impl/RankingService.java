package com.youcode.aftas.services.impl;

import com.youcode.aftas.dto.req.RankingReq;
import com.youcode.aftas.dto.resp.RankingResp;
import com.youcode.aftas.entities.Ranking;
import com.youcode.aftas.entities.Ranking_Id;
import com.youcode.aftas.exceptions.baseExsption;
import com.youcode.aftas.repositorys.RankingRepository;
import com.youcode.aftas.services.interfaces.GenericService;
import com.youcode.aftas.tools.Checks;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class RankingService implements GenericService<Ranking_Id, RankingResp, RankingReq> {


    private final RankingRepository repository;
    private final ModelMapper mapper;


    @Override
    public List<RankingResp> redAll() {
        List<RankingResp>rankings= repository.findAll().stream().map(ranking -> mapper.map(ranking,RankingResp.class)).toList();
        return rankings;
    }

    @Override
    public RankingResp getOne(Ranking_Id id) {
        return mapper.map(repository.findById(id),RankingResp.class);
    }

    @Override
    public RankingResp create(RankingReq rankingReq) {
//        int number=repository.findById(rankingReq.toEntity().getRanking()).get().
    if (Checks.checkDate(rankingReq.getCode())){
        return mapper.map(repository.save(rankingReq.toEntity()),RankingResp.class);

    }else {
        throw new baseExsption(" The competition date is old");
    }

    }

    @Override
    public RankingResp update( RankingReq rankingReq) {
        return null;
    }

    @Override
    public boolean delete(Ranking_Id rankingId) {
        try {
            repository.deleteById(rankingId);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }


}
