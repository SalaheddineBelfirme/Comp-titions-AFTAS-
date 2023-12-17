package com.youcode.aftas.dto.resp;

import com.youcode.aftas.entities.Ranking_Id;
import jakarta.persistence.EmbeddedId;

public class RankingResp {

    private Ranking_Id ranking;
    private int rank;
    private int score;

}
