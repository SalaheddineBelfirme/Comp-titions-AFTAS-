package com.youcode.aftas.dto.resp;

import com.youcode.aftas.entities.Hunting;
import com.youcode.aftas.entities.Ranking;
import com.youcode.aftas.enums.IdentityDocumentType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;
@Data
@Component
@NoArgsConstructor
public class MemberResp {

    private  int num ;
    private  String name;
    private String familyName;
    private Date accessionDate;
    private String nationality;
    private IdentityDocumentType identityDocumentType;
    private String identityNumber;
    @OneToMany(mappedBy = "member")
    private List<Ranking>rankings;
    @OneToMany(mappedBy = "member")
    private List<Hunting> huntings;
}
