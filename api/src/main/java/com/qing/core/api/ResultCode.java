package com.qing.core.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
public enum ResultCode {
    SUCCESS("200"),
    SERVICE_EXCEPTION("400"),
    UNAUTHORIZED("401"),
    ACCESS_DENIED("403"),
    FAILED("500"),
    ;

    @Getter
    private final String code;
}
