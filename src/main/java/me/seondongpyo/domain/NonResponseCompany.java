package me.seondongpyo.domain;


import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
public class NonResponseCompany extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NON_RESPONSE_COMPANY_ID")
    private Long id;

    @Column(name = "GUBUN")
    private String category;

    @Column(name = "HOISAMYUNG")
    private String companyName;
}
