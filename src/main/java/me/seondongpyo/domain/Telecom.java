package me.seondongpyo.domain;

import lombok.Getter;

@Getter
public enum Telecom {
    KT("KT"),
    SKT("SKT"),
    LGT("LGT"),
    KT_MVNO("KT 알뜰"),
    SKT_MVNO("SKT 알뜰"),
    LGT_MVNO("LGT 알뜰");

    private final String value;

    Telecom(String value) {
        this.value = value;
    }
}
