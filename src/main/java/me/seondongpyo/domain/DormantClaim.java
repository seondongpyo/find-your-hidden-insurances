package me.seondongpyo.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
public class DormantClaim extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DORMANT_CLAIM_ID")
    private Long id;

    @Column(name = "GUBUN")
    private String insuranceType;

    @Column(name = "HOISAMYUNG")
    private String companyName;

    @Column(name = "JEUNGSEOBEONHO")
    private String certificateNumber;

    @Column(name = "TONGHWAGUBUN")
    private String currencyType;

    @Column(name = "GEUMAEK")
    private int price;

    @Column(name = "MUNUICHEO")
    private String enquiry;

    @Column(name = "BIGO")
    private String remark;
}
