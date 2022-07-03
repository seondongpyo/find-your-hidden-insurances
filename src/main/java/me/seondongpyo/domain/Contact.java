package me.seondongpyo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Embeddable
public class Contact {

    @Enumerated(EnumType.STRING)
    private Telecom telecom;

    private String phoneNumber;

    private String email;

    private String postcode;

    private String address;
}
