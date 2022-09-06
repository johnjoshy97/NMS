package com.nintriva.repository.nms.repository;

import com.nintriva.repository.nms.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

//    @Query("select r FROM roles r WHERE r.role_name = ROLE_ADMIN")
//   Role findByRoleName(String role_name);
}
