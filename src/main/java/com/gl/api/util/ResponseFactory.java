package com.gl.api.util;

import com.gl.api.model.response.JResponseEntity;
import org.springframework.http.HttpStatus;

/**
 * Created by DANG DIM
 * Date     : 3/3/2018, 4:43 PM
 * Email    : d.dim@gl-f.com
 */

public final class ResponseFactory {

    public static <T> JResponseEntity<T> build() {
        return new JResponseEntity();
    }

    public static <T> JResponseEntity<T> build(String message) {
        return ResponseFactory.build(message, null);
    }

    public static <T> JResponseEntity<T> build(String message, HttpStatus httpStatus) {
        return ResponseFactory.build(message, httpStatus, null);
    }

    public static <T> JResponseEntity<T> build(String message, HttpStatus status, T body) {
        JResponseEntity<T> responseEntity = build();
        responseEntity.setMessage(message);
        responseEntity.setStatus(status);
        responseEntity.setData(body);
        return responseEntity;
    }

    public static <T> JResponseEntity<T> build(String message, HttpStatus status, String key, T body) {
        JResponseEntity<T> responseEntity = build(message, status);
        responseEntity.setData(body);
        return responseEntity;
    }
}
