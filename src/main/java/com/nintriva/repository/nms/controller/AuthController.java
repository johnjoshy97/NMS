package com.nintriva.repository.nms.controller;

import com.nintriva.repository.nms.entity.User;
import com.nintriva.repository.nms.entity.UserDetails;
import com.nintriva.repository.nms.payload.LoginDto;
import com.nintriva.repository.nms.payload.SignUpDto;
import com.nintriva.repository.nms.payload.UserDetailsDto;
import com.nintriva.repository.nms.repository.RoleRepository;
import com.nintriva.repository.nms.repository.UserDetailsRepository;
import com.nintriva.repository.nms.repository.UserRepository;
import com.nintriva.repository.nms.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserDetailsRepository userDetailsRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

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
        if (userRepository.existsByUsername(signUpDto.getUsername())) {
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }
        // add check for email exists in DB
        if (userRepository.existsByEmail(signUpDto.getEmail())) {
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }
        // create user object
        User user = new User();
        user.setEmployee_code(signUpDto.getEmployee_code());
        user.setUsername(signUpDto.getUsername());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        user.setMobile(signUpDto.getMobile());
        user.setDate_time(signUpDto.getDate_time());

//        Role roles = roleRepository.findByRole_name("ROLE_ADMIN");
//        user.setRoles(Collections.singleton(roles));
        userRepository.save(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Response> registerUser(@RequestBody UserDetailsDto userDetailsDto) {
        try {
            // add check for username exists in a DB
            if (userDetailsRepository.existsByUsername(userDetailsDto.getUsername())) {
                Response response1 = Response.builder().success(false).message("Username is already taken!").build();
                return new ResponseEntity<>(response1, HttpStatus.BAD_REQUEST);
            }
            // add check for email exists in DB
            if (userDetailsRepository.existsByEmail(userDetailsDto.getEmail())) {
                Response response2 = Response.builder().success(false).message("Email is already taken!").build();

                return new ResponseEntity<>(response2, HttpStatus.BAD_REQUEST);
            }
            UserDetails ud = new UserDetails();
        ud.setUserid(UUID.randomUUID());
            ud.setEmployee_code(userDetailsDto.getEmployee_code());
            ud.setUsername(userDetailsDto.getUsername());
            ud.setEmail(userDetailsDto.getEmail());
            ud.setMobile(userDetailsDto.getMobile());
            ud.setDate_format(LocalDate.now());
            ud.setJoining_date(userDetailsDto.getJoining_date());
            ud.setTimezone(userDetailsDto.getTimezone());
            ud.setDepartment(userDetailsDto.getDepartment());
            ud.setLast_name(userDetailsDto.getLast_name());
            ud.setManager(userDetailsDto.getManager());
            ud.setOffice(userDetailsDto.getOffice());
            ud.setDate_of_birth(userDetailsDto.getDate_of_birth());
            ud.setSalary_wages(userDetailsDto.getSalary_wages());
            ud.setGender(userDetailsDto.getGender());
            ud.setWeekly_working_hours(userDetailsDto.getWeekly_working_hours());
            ud.setAadhar_number(userDetailsDto.getAadhar_number());
            ud.setPAN_number(userDetailsDto.getPAN_number());

            userDetailsRepository.save(ud);
            Response response3 = Response.builder().success(true).message("User created!").build();

            return new ResponseEntity<>(response3, HttpStatus.OK);
        }
        catch (Exception e){
            Response response4= Response.builder().success(false).message("Incomplete Field").build();
            return new ResponseEntity<>(response4, HttpStatus.OK);

        }
    }
}