package com.datu3.cmcglobal.practice.exeption;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomException extends RuntimeException{
    private int httpCode;
    private String code;
    private String errorDetail;

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, int httpCode) {
        super(message);
        this.httpCode = httpCode;
    }

    public CustomException(String message, int httpCode, String code) {
        super(message);
        this.httpCode = httpCode;
        this.code = code;
    }

    public CustomException(String message, int httpCode, String code, String errorDetail) {
        super(message);
        this.httpCode = httpCode;
        this.code = code;
        this.errorDetail = errorDetail;
    }
}
