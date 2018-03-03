package com.gl.api.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

/**
 * Created by DANG DIM
 * Date     : 3/3/2018, 4:35 PM
 * Email    : d.dim@gl-f.com
 */

public final class JResponseEntity<T>{

    @JsonProperty("MESSAGE")
    private String message;

    @JsonProperty("CODE")
    private Integer code;

    @JsonProperty("STATE")
    private Boolean state;

    @JsonProperty("HTTP_STATUS")
    private HttpStatus status;

    @JsonProperty("DATA")
    private T data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}




