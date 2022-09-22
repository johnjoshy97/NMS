package com.nintriva.repository.nms.payload;


import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.UUID;

@Data
public class UserDetailsDto {

    private UUID id;
    @NotEmpty(message = "Employee code cannot be null")
    private String employee_code;
    @NotEmpty(message = "Username cannot be null")
    private String username;
    @NotEmpty(message = "Email cannot be null")
    private String email;
    @NotEmpty(message = "Mobile cannot be null")
    private String mobile;
    private Date date_format;
    private Date joining_date;
    private String timezone;
    private String department;
    private String last_name;
    private String manager ;
    private String office;
    private Date date_of_birth;
    private int salary_wages;
    private String gender;
    private String weekly_working_hours;
    private int aadhar_number;
    private String PAN_number;
}
