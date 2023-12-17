package com.youcode.aftas.entities;

import com.youcode.aftas.enums.IdentityDocumentType;
import com.youcode.aftas.tools.IdGenerator;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Entity(name = "member")
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int num ;
    private  String name;
    private String familyName;
    private Date accessionDate;
    private String nationality;
    private IdentityDocumentType identityDocumentType;
    private String identityNumber;

    @OneToMany(mappedBy = "member")
    private List<Hunting> huntings;

    @OneToMany(mappedBy = "ranking.num")
    private List<Ranking>rankings;


//    @ManyToMany
//    @JoinTable(
//       name = "Ranking",
//       joinColumns=@JoinColumn(name = "member_num"),
//       inverseJoinColumns = @JoinColumn(name = "competition_code")
//    )
//    private  Set<Competition> competitionSet;




}
