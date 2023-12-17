package com.youcode.aftas.entities;

import com.youcode.aftas.tools.IdGenerator;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "competition")
public class Competition {
    @Id
    private String code;
    @Column(unique = true)
    private Date date;
    private Time starTime;
    private Time endTime;
    private int numberOfParticipants;
    private  String  location;
    private double amount;
    @OneToMany(mappedBy = "competition",cascade = CascadeType.ALL)
    private  List<Hunting>huntingList;

    @OneToMany(mappedBy = "ranking.code",cascade = CascadeType.ALL)
    private List<Ranking> rankings;
    @PrePersist
    public void prePersist() {
        if (location == null) {
            throw new IllegalStateException("location cannot be null");
        }
        this.code = IdGenerator.generateId(location);
    }




}
