package com.qing.core.exception;

public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = -7561648875099918786L;
    protected String code = "400";

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String errorCode, String message) {
        super(message);
        this.code = errorCode;
    }

    public ServiceException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.code = errorCode;
    }

    public String getCode() {
        return code;
    }
}
