package com.qing.core.api;


public enum ResultCode {
    SUCCESS(200, "操作成功"),
    FAILED(500, "服务器异常"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "无权限访问");
    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
