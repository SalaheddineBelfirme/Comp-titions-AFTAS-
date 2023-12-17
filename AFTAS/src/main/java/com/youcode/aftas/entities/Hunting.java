package com.youcode.aftas.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hunting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    private  int nomberOfFish;
    @ManyToOne()
    private Member member;
    @ManyToOne(cascade = CascadeType.ALL)
    private Fich fich;
    @ManyToOne(cascade = CascadeType.ALL)
    private Competition competition;



}
