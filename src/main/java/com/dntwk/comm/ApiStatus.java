package com.dntwk.comm;

import lombok.Getter;

public enum ApiStatus {
    SUCCESS("SUCCESS"),FAIL("FAIL");

    @Getter
    private final String status;

    ApiStatus(String status) {
        this.status = status;
    }
}
