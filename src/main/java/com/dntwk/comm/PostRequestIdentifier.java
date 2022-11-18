package com.dntwk.comm;

import lombok.Getter;

public enum PostRequestIdentifier {
    NAME("NAME"),
    LAYER("LAYER"),
    SORTED("SORTED"),
    CONTENTS("CONTENTS");

    @Getter
    private final String status;

    PostRequestIdentifier(String status) {
        this.status = status;
    }
}
