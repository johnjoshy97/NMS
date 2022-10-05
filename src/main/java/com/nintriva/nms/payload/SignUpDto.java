package com.nintriva.nms.payload;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SignUpDto {
    private String name;
    private String employeeCode;
    private String username;
    private String email;
    private String password;
    private String mobile;
    private LocalDate Date_time;
}