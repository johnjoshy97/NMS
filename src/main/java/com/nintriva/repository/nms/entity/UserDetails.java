package com.nintriva.repository.nms.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "nms_user_details")
public class UserDetails {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type="org.hibernate.type.PostgresUUIDType")
    private UUID userid;

    @NotEmpty(message = "Employee code cannot be null")
    private String employee_code;
    @NotEmpty(message = "Username cannot be null")
    private String username;
    @NotEmpty(message = "Email cannot be null")
    private String email;
    @NotEmpty(message = "Mobile cannot be null")
    private String mobile;
    private LocalDate date_format;
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

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "userid", referencedColumnName = "userid")
//    private List<User> user;


}
