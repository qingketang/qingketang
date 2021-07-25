package com.qing.core.api;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class ExceptionResponse {
    @Setter(AccessLevel.NONE)
    private Boolean ok = false;
    private String code;
    private String traceId;
    private String message;
    private String detail;
}
