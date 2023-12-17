package com.youcode.aftas.tools;

import com.youcode.aftas.services.impl.CompetitionServiceImpl;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class Checks {

    @Autowired
    private static CompetitionServiceImpl  competitionService;

    public Checks(CompetitionServiceImpl service){
        competitionService=service;
    }
    public static boolean checkDate(String code){
        return competitionService.checkDate(code);
    }
}
