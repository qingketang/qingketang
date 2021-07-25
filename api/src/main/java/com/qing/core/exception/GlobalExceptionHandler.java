package com.qing.core.exception;

import com.qing.core.api.ExceptionResponse;
import com.qing.core.api.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.io.PrintWriter;
import java.io.StringWriter;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler({ServiceException.class})
    public ResponseEntity<ExceptionResponse> handle(ServiceException serviceException) {
        ExceptionResponse error = new ExceptionResponse();
        error.setCode(serviceException.getCode());
        error.setMessage(serviceException.getMessage());

        return new ResponseEntity<>(error, HttpStatus.OK);
    }

    @ExceptionHandler(Throwable.class)
    public final ResponseEntity<ExceptionResponse> handle(Exception e) {
        log.error(e.getMessage());
        log.error(this.getStackTrace(e));

        ExceptionResponse error = new ExceptionResponse();
        error.setCode(ResultCode.FAILED.getCode());
        error.setMessage(e.getMessage());
        error.setDetail(e.getLocalizedMessage());

        return new ResponseEntity<>(error, HttpStatus.OK);
    }

    private String getStackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        try {
            throwable.printStackTrace(pw);
            return sw.toString();
        } finally {
            pw.close();
        }
    }
}
