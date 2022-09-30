package com.nintriva.repository.nms.payload;


import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.UUID;

@Data
public class UserDetailsDto {

//    private UUID id;
    private UUID userid;
    @NotEmpty(message = "first_name cannot be null")
    private String first_name;
    @NotEmpty(message = "last_name cannot be null")

    private String last_name;

    @NotEmpty(message = "Employee code cannot be null")
    private String employeeCode;
    @NotEmpty(message = "Email cannot be null")
    private String email;
    private String mobile;
    private Date date_of_birth;
    private Date joining_date;
    private String manager ;
    private String employee_address ;
    private String employment_type ;
    private String work_status ;
    private int salary;
    private String probation_status ;
    private String probation_period ;
    private String gender;
    private String designation;
    private String PAN_number;
    private String daily_work_hour;
    private String weekly_work_hour;
    private int aadhar_number;
    @NotEmpty(message = "Department cannot be null")

    private String department;
}
