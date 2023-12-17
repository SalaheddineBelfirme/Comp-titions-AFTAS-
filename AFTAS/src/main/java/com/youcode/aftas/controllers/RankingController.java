package com.youcode.aftas.controllers;

import com.youcode.aftas.dto.req.RankingReq;
import com.youcode.aftas.dto.resp.RankingResp;
import com.youcode.aftas.entities.Ranking;
import com.youcode.aftas.entities.Ranking_Id;
import com.youcode.aftas.exceptions.baseExsption;
import com.youcode.aftas.services.impl.RankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/Ranking")
public class RankingController {

    @Autowired
    private RankingService service;
    @GetMapping()
    public ResponseEntity<List<RankingResp>>getAll(){
        return ResponseEntity.ok(service.redAll());
    }
    @PostMapping()
    public ResponseEntity<String>create(@RequestBody RankingReq rankingReq){
        service.create(rankingReq);
        return new ResponseEntity<>("you are with us now ", HttpStatus.CREATED);

    }
    @DeleteMapping
    public ResponseEntity<String>delete(Ranking_Id id){
      if (service.delete(id)){
          return  ResponseEntity.ok("deleted");
      }
      else {
            throw new baseExsption("not Found");
        }

    }




}
