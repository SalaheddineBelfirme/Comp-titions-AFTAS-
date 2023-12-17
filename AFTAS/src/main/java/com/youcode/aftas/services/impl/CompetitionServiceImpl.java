package com.youcode.aftas.services.impl;

import com.youcode.aftas.dto.req.CompetitionReq;
import com.youcode.aftas.dto.resp.CompetitionResp;
import com.youcode.aftas.entities.Competition;
import com.youcode.aftas.exceptions.Duplicated_key;
import com.youcode.aftas.exceptions.baseExsption;
import com.youcode.aftas.repositorys.CompetitionRepository;
import com.youcode.aftas.services.interfaces.GenericService;
import com.youcode.aftas.tools.Checks;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@Service
public class CompetitionServiceImpl implements GenericService<String, CompetitionResp, CompetitionReq> {

    @Autowired
    private   CompetitionRepository repository;
    @Autowired
    private ModelMapper mapper;

    public CompetitionServiceImpl(CompetitionRepository repository){
        this.repository=repository;
    }
    @Override
    public List<CompetitionResp> redAll() {
        List<CompetitionResp> competitionResps=repository.findAll()
            .stream().map(competition -> mapper.map(competition,CompetitionResp.class)).toList();
        return competitionResps;
    }

    @Override
    public CompetitionResp getOne(String Id) {

        return null;
    }

    @Override
    public CompetitionResp create(CompetitionReq competitionReq) {
        Competition competition=mapper.map(competitionReq,Competition.class);
        try {
            repository.save(competition);
            return mapper.map(competitionReq,CompetitionResp.class);

        }
        catch ( DuplicateKeyException ex){
            throw new Duplicated_key("we are already have a competition in the date and the city");
        }
        catch (Exception e){
            throw new baseExsption("we are already have a competition in the date"+competitionReq.getDate());
        }


    }

    @Override
    public CompetitionResp update(CompetitionReq competitionReq) {
        return null;
    }

    @Override
    public boolean delete(String code) {
        try {
            Competition competition=repository.getReferenceById(code);
            repository.delete(competition);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean checkDate(String code) {
        Optional<Competition> competitionOptional = repository.findById(code);
        if (competitionOptional.isPresent()) {
            LocalDate today = LocalDate.now();
            LocalDate competitionStartDate = competitionOptional.get().getDate().toLocalDate();
            long daysDifference = ChronoUnit.DAYS.between(today, competitionStartDate);
            if (daysDifference <= 1) {
                return false;
            }
        }
          return true;
    }

}
