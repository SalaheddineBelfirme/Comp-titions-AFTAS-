package com.youcode.aftas.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Fich {
    @Id
    private Long id;
    private String name;
    private  double averageWeight ;
    @ManyToOne(cascade = CascadeType.ALL)
    private Level level;
    @OneToMany(mappedBy ="fich" )
    private List<Hunting>huntings;

}
