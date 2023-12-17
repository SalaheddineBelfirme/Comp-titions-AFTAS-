package com.youcode.aftas.dto.resp;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Time;

@Data
@Component
@NoArgsConstructor
public class CompetitionResp {
    private Date date;
    private Time starTime;
    private Time endTime;
    private int numberOfParticipants;
    private  String  location;
    private double amount;

}
