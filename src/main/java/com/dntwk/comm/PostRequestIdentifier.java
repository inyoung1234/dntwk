package com.dntwk.comm;

import lombok.Getter;

public enum PostRequestIdentifier {
    NAME("NAME"),
    LAYER("LAYER"),
    SORT("SORT"),
    CONTENTS("CONTENTS");

    @Getter
    private final String status;

    PostRequestIdentifier(String status) {
        this.status = status;
    }
}
