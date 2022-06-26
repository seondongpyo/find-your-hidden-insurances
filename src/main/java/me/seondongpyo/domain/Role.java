package me.seondongpyo.domain;

import lombok.Getter;

@Getter
public enum Role {
    USER("사용자"),
    MANAGER("관리자"),
    ADMIN("어드민");

    private final String value;

    Role(String value) {
        this.value = value;
    }
}
