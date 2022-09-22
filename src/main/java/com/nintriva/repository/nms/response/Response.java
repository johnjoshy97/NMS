package com.nintriva.repository.nms.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Response {
    private boolean success;
    private String message;
}
