package com.qing.core.aspect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class WebLog {
    private String username;
    private String ip;
    private String method;
    private String url;
    private String parameter;
    private String description;
    private Long startTime;
}
