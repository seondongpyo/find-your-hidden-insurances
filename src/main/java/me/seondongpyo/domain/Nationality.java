package me.seondongpyo.domain;

import lombok.Getter;

@Getter
public enum Nationality {
    DOMESTIC("내국인"),
    FOREIGNER("외국인");

    private final String value;

    Nationality(String value) {
        this.value = value;
    }
}
