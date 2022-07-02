package me.seondongpyo.domain;

import lombok.Getter;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Embeddable
public class Contact {

    @Enumerated(EnumType.STRING)
    private Telecom telecom;

    private String phoneNumber;

    private String email;

    private String postcode;

    private String address;
}
