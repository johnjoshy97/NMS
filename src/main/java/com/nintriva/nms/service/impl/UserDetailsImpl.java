    package com.nintriva.nms.service.impl;

    import com.nintriva.nms.entity.Select;
    import com.nintriva.nms.entity.User;
    import com.nintriva.nms.payload.SignUpDto;
    import com.nintriva.nms.payload.UserDetailsDto;
    import com.nintriva.nms.repository.*;
    import com.nintriva.nms.response.Response;
    import com.nintriva.nms.service.UserDetails;
    import lombok.RequiredArgsConstructor;
    import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
    import org.keycloak.OAuth2Constants;
    import org.keycloak.admin.client.Keycloak;
    import org.keycloak.admin.client.KeycloakBuilder;
    import org.keycloak.admin.client.resource.RealmResource;
    import org.keycloak.admin.client.resource.UsersResource;
    import org.keycloak.representations.idm.UserRepresentation;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.UUID;
    @Service
    @RequiredArgsConstructor
    public class UserDetailsImpl implements UserDetails {

        private final PasswordEncoder passwordEncoder;
        private final UserDetailsRepository userDetailsRepository;
        private final UserRepository userRepository;
//        private final RoleRepository roleRepository;

        @Autowired
        UserEntityRepository userEntityRepository;
        private String authServerUrl = "http://localhost:8080/auth/";
        private String clientId = "nintriva";
        private String role = "admin";
        //Get client secret from the Keycloak admin console (in the credential tab)
        private String clientSecret = "fEsv6SxscDLbN5JhYTRWKtg2hB7JryLD";

        @Override
        public ResponseEntity<Response> addEmployee(UserDetailsDto userDetailsDto) {


            try {

                if (userDetailsRepository.existsByEmployeeCode(userDetailsDto.getEmployeeCode())) {
                    Response response1 = Response.builder().success(false).message("employee_code is already taken!").build();
                    return new ResponseEntity<>(response1, HttpStatus.BAD_REQUEST);
                }
                // add check for email exists in DB
                if (userDetailsRepository.existsByEmail(userDetailsDto.getEmail())) {
                    Response response2 = Response.builder().success(false).message("Email is already taken!").build();

                    return new ResponseEntity<>(response2, HttpStatus.BAD_REQUEST);
                }
                    if(userDetailsDto.getFirst_name()==""){
                        Response response5 = Response.builder().success(false).message("First name cannot be empty").build();
                        return new ResponseEntity<>(response5,HttpStatus.BAD_REQUEST);
                    }
                if(userDetailsDto.getLast_name()==""){
                    Response response6 = Response.builder().success(false).message("Last name cannot be empty").build();
                    return new ResponseEntity<>(response6,HttpStatus.BAD_REQUEST);
                }
                if(userDetailsDto.getEmail()==""){
                    Response response7 = Response.builder().success(false).message("Email cannot be empty").build();
                    return new ResponseEntity<>(response7,HttpStatus.BAD_REQUEST);
                }

                if(userDetailsDto.getEmployeeCode()==""){
                    Response response8 = Response.builder().success(false).message("Employee code cannot be empty").build();
                    return new ResponseEntity<>(response8,HttpStatus.BAD_REQUEST);
                }
                if(userDetailsDto.getDepartment()==""){
                    Response response9 = Response.builder().success(false).message("Department cannot be empty").build();
                    return new ResponseEntity<>(response9,HttpStatus.BAD_REQUEST);
                }


                Keycloak keycloak = KeycloakBuilder.builder().serverUrl(authServerUrl)
                        .grantType(OAuth2Constants.PASSWORD).realm("master").clientId("admin-cli")
                        .username("Admin").password("admin")
                        .resteasyClient(new ResteasyClientBuilder().connectionPoolSize(10).build()).build();

                keycloak.tokenManager().getAccessToken();
                com.nintriva.nms.entity.UserDetails ud = new com.nintriva.nms.entity.UserDetails();
                ud.setUserid(UUID.randomUUID());

                UserRepresentation user = new UserRepresentation();
                user.setEnabled(true);

                user.setUsername(userDetailsDto.getEmail());
                user.setFirstName(userDetailsDto.getFirst_name());
                user.setLastName(userDetailsDto.getLast_name());
                user.setEmail(userDetailsDto.getEmail());


                RealmResource realmResource = keycloak.realm("NMS-realm");
                UsersResource usersResource = realmResource.users();

                javax.ws.rs.core.Response response = usersResource.create(user);
                userDetailsDto.setStatusCode(response.getStatus());
                userDetailsDto.setStatus(response.getStatusInfo().toString());

                ud.setEmployeeCode(userDetailsDto.getEmployeeCode());
                ud.setFirst_name(userDetailsDto.getFirst_name());
                ud.setLast_name(userDetailsDto.getLast_name());
                    ud.setEmail(userDetailsDto.getEmail());

                ud.setDate_of_birth(userDetailsDto.getDate_of_birth());
                ud.setJoining_date(userDetailsDto.getJoining_date());
                ud.setManager(userDetailsDto.getManager());
                ud.setMobile(userDetailsDto.getMobile());
                ud.setEmployee_address(userDetailsDto.getEmployee_address());
                ud.setEmployment_type(userDetailsDto.getEmployment_type());
                ud.setWork_status(userDetailsDto.getWork_status());
                ud.setSalary(userDetailsDto.getSalary());
                ud.setProbation_status(userDetailsDto.getProbation_status());
                ud.setProbation_period(userDetailsDto.getProbation_period());
                ud.setGender(userDetailsDto.getGender());
                ud.setDesignation(userDetailsDto.getDesignation());
                ud.setPAN_number(userDetailsDto.getPAN_number());
                ud.setDaily_work_hour(userDetailsDto.getDaily_work_hour());
                ud.setWeekly_work_hour(userDetailsDto.getWeekly_work_hour());
                ud.setAadhar_number(userDetailsDto.getAadhar_number());
                ud.setDepartment(userDetailsDto.getDepartment());
                try{
                userDetailsRepository.save(ud);
                Response response3 = Response.builder().success(true).message("User created!").build();
                    return new ResponseEntity<>(response3, HttpStatus.OK);
                }
                catch (Exception e){
                    Response response1=Response.builder().success(false).message("invalid emailId").build();
                    return new ResponseEntity<>(response1,HttpStatus.BAD_REQUEST);
                }

            } catch (Exception e) {

                Response response4 = Response.builder().success(false).message("Incomplete Field").build();
                return new ResponseEntity<>(response4, HttpStatus.OK);
            }

//            return null;
        }



        @Override
        public ResponseEntity<?> employeeReg(SignUpDto signUpDto) {
            if (userRepository.existsByUsername(signUpDto.getUsername())) {
                return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
            }
            // add check for email exists in DB
            if (userRepository.existsByEmail(signUpDto.getEmail())) {
                return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
            }
            // create user object
            userRepository.save(User.builder()
                    .employeeCode(signUpDto.getEmployeeCode())
                    .username(signUpDto.getUsername())
                    .email(signUpDto.getEmail())
                    .password(passwordEncoder.encode(signUpDto.getPassword()))
                    .mobile(signUpDto.getMobile())
                    .date_time(signUpDto.getDate_time())
                    .build());
            return new ResponseEntity<>("User registered successfully", HttpStatus.OK);

        }


    }
