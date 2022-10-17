package com.nintriva.nms.repository;

import com.nintriva.nms.entity.Select;
import com.nintriva.nms.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDropdownRepository extends JpaRepository<Select,Integer> {

    @Query(value = "SELECT * FROM TABLE Nms_select WHERE label = ?")
    List<String> ListOptions(String label);


}
