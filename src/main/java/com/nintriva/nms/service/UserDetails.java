package com.nintriva.nms.service;

import com.nintriva.nms.entity.Select;
import com.nintriva.nms.payload.SignUpDto;
import com.nintriva.nms.payload.UserDetailsDto;
import com.nintriva.nms.response.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface UserDetails {
    public ResponseEntity<Response> addEmployee(UserDetailsDto user) ;
            ResponseEntity<?> employeeReg(SignUpDto signUpDto);


}
