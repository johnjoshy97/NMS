package com.nintriva.nms.repository;

import com.nintriva.nms.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository <UserEntity,String>{

}
