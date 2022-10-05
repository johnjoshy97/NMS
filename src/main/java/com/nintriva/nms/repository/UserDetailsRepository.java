package com.nintriva.nms.repository;

import com.nintriva.nms.entity.User;
import com.nintriva.nms.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailsRepository extends JpaRepository<UserDetails,Integer> {
    Optional<User> findByEmail(String email);
//    Optional<User> findByUsernameOrEmail(String username, String email);
//    Optional<User> findByUsername(String username);
//    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Optional<User> findByEmployeeCode(String employeeCode);
    Boolean existsByEmployeeCode(String employeeCode);
}