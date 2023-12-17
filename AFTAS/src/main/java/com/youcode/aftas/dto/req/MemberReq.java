package com.youcode.aftas.dto.req;

import com.youcode.aftas.enums.IdentityDocumentType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Data
@NoArgsConstructor
@Component
public class MemberReq {

    private  int num ;
    private  String name;
    private String familyName;
    private Date accessionDate;
    private String nationality;
    private IdentityDocumentType identityDocumentType;
    private String identityNumber;
}
