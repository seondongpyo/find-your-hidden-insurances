package me.seondongpyo.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
public class Insurance extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INSURANCE_ID")
    private Long id;

    @Column(name = "HOISAMYUNG")
    private String companyName;

    @Column(name = "GYEYAKGWANGYE")
    private String contractRelation;

    @Column(name = "SANGPUMMYUNG")
    private String productName;

    @Column(name = "JEONHWABEONHO")
    private String phoneNumber;

    @Column(name = "BOJANGSIJAKIL")
    private String guaranteeStartDate;

    @Column(name = "JEUNGGWONBUNHO")
    private String policyNumber;

    @Column(name = "GYEYAKSANGTAE")
    private String contractStatus;

    @Column(name = "BOJANGJONGRYOIL")
    private String guaranteeEndDate;

    @Column(name = "DAMDANGJEOMPO")
    private String branch;

    @Column(name = "GUBUN")
    private String category;
}
