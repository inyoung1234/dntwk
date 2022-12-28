package com.dntwk.comm.auth;

import lombok.Getter;

public enum Exists {
    EXISTS("EXISTS"),NOTEXISTS("NOTEXIST");

    @Getter
    private final String value;

    Exists(String value) {
        this.value=value;
    }
}
