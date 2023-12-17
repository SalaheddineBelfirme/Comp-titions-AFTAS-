package com.youcode.aftas.dto.req;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Time;

@Component
@NoArgsConstructor
@Data
public class CompetitionReq {
    private Date date;
    private Time starTime;
    private Time endTime;
    private int numberOfParticipants;
    private  String  location;
    private double amount;
}
