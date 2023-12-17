package com.youcode.aftas.repositorys;

import com.youcode.aftas.entities.Ranking;
import com.youcode.aftas.entities.Ranking_Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankingRepository extends JpaRepository<Ranking, Ranking_Id> {

}
