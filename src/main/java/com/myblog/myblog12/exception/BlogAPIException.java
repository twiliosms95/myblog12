package com.myblog.myblog12.exception;

import org.springframework.http.HttpStatus;

public class BlogAPIException extends Throwable {
    public BlogAPIException(HttpStatus httpStatus, String invalidJwtSignature) {
    }
}
