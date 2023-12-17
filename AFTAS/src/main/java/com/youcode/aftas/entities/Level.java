package com.youcode.aftas.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int code ;
    private  String description;
    private int points;
    @OneToMany(mappedBy = "level")
    private List<Fich> fichList;
}
