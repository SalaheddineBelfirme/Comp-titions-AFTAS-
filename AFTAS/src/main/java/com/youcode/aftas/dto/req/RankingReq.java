package com.youcode.aftas.dto.req;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youcode.aftas.entities.Competition;
import com.youcode.aftas.entities.Member;
import com.youcode.aftas.entities.Ranking;
import com.youcode.aftas.entities.Ranking_Id;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data
public class RankingReq {

    private String code;
    private int num;
    private int rank;
    private int score;


    public Ranking toEntity(){
        Competition competition = Competition
                .builder()
                .code(this.code)
                .build();
        Member member = Member
                .builder()
                .num(this.num)
                .build();
        Ranking_Id rankingId = Ranking_Id
                .builder()
                .num(member)
                .code(competition)
                .build();
        return Ranking
                .builder()
                .ranking(rankingId)
                .score(this.score)
                .rank(this.rank)
                .build();
    }


}
