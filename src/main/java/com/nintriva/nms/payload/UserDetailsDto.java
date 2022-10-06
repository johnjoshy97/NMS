package com.nintriva.nms.payload;


import lombok.*;
import org.springframework.lang.Nullable;
import java.util.Date;
import java.util.UUID;

@Data
public class UserDetailsDto {

//    private UUID id;
    private UUID userid;
//    @NotNull(message = "first_name cannot be null")
    private String first_name;
//    @NotEmpty(message = "last_name cannot be null")
    private String last_name;
//    @NotEmpty(message = "Employee code cannot be null")
    private String employeeCode;
//    @NotEmpty(message = "Email cannot be null")
     private String email;
//    @NotEmpty(message = "Department cannot be null")
    private String department;
    @Nullable private String mobile;
    @Nullable private Date date_of_birth;
    @Nullable private Date joining_date;
    @Nullable private String manager ;
    @Nullable private String employee_address ;
    @Nullable private String employment_type ;
    @Nullable private String work_status ;
    @Nullable private int salary;
    @Nullable private String probation_status ;
    @Nullable private String probation_period ;
    @Nullable private String gender;
    @Nullable private String designation;
    @Nullable private String PAN_number;
    @Nullable private String daily_work_hour;
    @Nullable private String weekly_work_hour;
    @Nullable private int aadhar_number;

    @Nullable private int StatusCode;
    private String Status;
}
