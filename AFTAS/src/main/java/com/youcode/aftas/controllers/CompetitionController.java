package com.youcode.aftas.controllers;


import com.youcode.aftas.dto.req.CompetitionReq;
import com.youcode.aftas.dto.resp.CompetitionResp;
import com.youcode.aftas.services.impl.CompetitionServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/competition")
public class CompetitionController {

    @Autowired
    private final CompetitionServiceImpl service;
    public CompetitionController(CompetitionServiceImpl competitionService){
        this.service=competitionService;
    }

    @GetMapping
    public ResponseEntity<List<CompetitionResp>>getAll(){
        List<CompetitionResp> respList=service.redAll();
        if (respList.isEmpty()){
            return new ResponseEntity<>( null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( service.redAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CompetitionResp>create(@RequestBody CompetitionReq competitionReq){
        return new ResponseEntity<>(service.create(competitionReq),HttpStatus.CREATED);

    }
    @DeleteMapping
    public ResponseEntity<String>delete(@PathVariable String code){
        if (service.delete(code)){
          return   new ResponseEntity<>("the Competition was deleted",HttpStatus.FOUND);
        }
        return   new ResponseEntity<>("try again",HttpStatus.NOT_FOUND);

    }
}
