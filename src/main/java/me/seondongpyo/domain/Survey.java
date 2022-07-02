package me.seondongpyo.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Getter
@Embeddable
public class Survey {

    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String answer5;
}
