package com.nintriva.nms.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Builder
@Data
public class Response {
    private boolean success;
    private String message;
    private HttpStatus statusCode;
    private Object data;
}
