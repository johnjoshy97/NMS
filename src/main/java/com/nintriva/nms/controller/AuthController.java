package com.nintriva.nms.controller;

import com.nintriva.nms.payload.ListOptionDto;
import com.nintriva.nms.payload.LoginDto;
import com.nintriva.nms.payload.SignUpDto;
import com.nintriva.nms.payload.UserDetailsDto;
import com.nintriva.nms.response.Response;
import com.nintriva.nms.security.CustomUserDetailsService;

import com.nintriva.nms.service.ListOptionService;
import com.nintriva.nms.service.UserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService service;
    private final UserDetails userDetails;

    @Autowired
    private ListOptionService listOptionService;
    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto) {
        // add check for username exists in a DB
        return userDetails.employeeReg(signUpDto);
    }

    @PostMapping("/create")
    public ResponseEntity<Response> registerUser(@RequestBody @Valid UserDetailsDto userDetailsDto) {
        //Create new user in keycloak
        return userDetails.addEmployee(userDetailsDto);
    }

    @GetMapping(path = "/listing/{label}")
    public ResponseEntity<List<ListOptionDto>> insertOptions(@PathVariable String label){

        return ResponseEntity.ok().body(listOptionService.insertOption(label));
    }

}