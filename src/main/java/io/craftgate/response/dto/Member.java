package io.craftgate.response.dto;

import io.craftgate.model.MemberType;
import io.craftgate.model.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    private Long id;
    private LocalDateTime createdDate;
    private Status status;
    private Boolean isBuyer;
    private Boolean isSubMerchant;
    private MemberType memberType;
    private String memberExternalId;
    private String name;
    private String email;
    private String phoneNumber;
    private String contactName;
    private String contactSurname;
    private String identityNumber;
    private String legalCompanyTitle;
    private String taxOffice;
    private String taxNumber;
}
