package me.seondongpyo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate birthDate;

    private String gender;

    private String nationality;

    private String telecom;

    private String phoneNumber;

    private String email;

    private String zipCode;

    private String address;

    private String agreement;

    private String answer1;

    private String answer2;

    private String answer3;

    private String answer4;

    private String answer5;
}
