package com.youcode.aftas.controllers;

import com.youcode.aftas.dto.req.MemberReq;
import com.youcode.aftas.dto.resp.MemberResp;
import com.youcode.aftas.entities.Member;
import com.youcode.aftas.services.impl.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/member")
@CrossOrigin(origins = "http://localhost:4200")
public class MemberController {

    @Autowired
    private final MemberServiceImpl service;

    public MemberController(MemberServiceImpl memberService){
        this.service=memberService;
    }

    @GetMapping
    public ResponseEntity<List<MemberResp>>getAll(){
        return new ResponseEntity<>(service.redAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<MemberResp>create(@RequestBody MemberReq memberReq){
       return new ResponseEntity<>(service.create(memberReq),HttpStatus.CREATED);
    }

    @DeleteMapping("{num}")
    public ResponseEntity<String>delete(@PathVariable Integer  num){
        if(service.delete(num)){
            return new ResponseEntity<>("the Memebr was deleted",HttpStatus.FOUND);
        }
        return new ResponseEntity<>("try again",HttpStatus.NOT_FOUND);
    }
    @PutMapping()
    public ResponseEntity<MemberResp>update(@RequestBody MemberReq memberReq){

        MemberResp memberResp=service.update(memberReq);
        if (memberResp!=null){
            return  ResponseEntity.ok(memberResp);
        }
        return new ResponseEntity<>(memberResp,HttpStatus.NOT_FOUND);

    }


}
