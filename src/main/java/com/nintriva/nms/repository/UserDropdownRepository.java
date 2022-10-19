package com.nintriva.nms.repository;

import com.nintriva.nms.entity.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDropdownRepository extends JpaRepository<Select,Integer> {

        @Query(value = "SELECT n FROM Select n WHERE n.label = :label")
        List<String> ListOptions(String label);


}
