package me.seondongpyo.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
public class UnclaimedClaim extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UNCLAIMED_CLAIM_ID")
    private Long id;

    @Column(name = "HOISAMYUNG")
    private String companyName;

    @Column(name = "BOHUMGEUMYUHYEONG")
    private String insuranceMoneyType;

    @Column(name = "JEUNGGWONBUNHO")
    private String policyNumber;

    @Column(name = "SANGPUMMYUNG")
    private String productName;

    @Column(name = "GYEYAKGWANGYE")
    private String contractRelation;

    @Column(name = "GYEYAKCHEGYEOLIL")
    private String contractStartDate;

    @Column(name = "GEUMAEK")
    private int price;

    @Column(name = "GEUMAEKGIJUNIL")
    private String priceBasicDate;

    @Column(name = "GASANIJA")
    private int interest;

    @Column(name = "IJAGIJUNIL")
    private String interestBasicDate;
}
