package com.nintriva.nms.repository;

import com.nintriva.nms.entity.Select;
import com.nintriva.nms.payload.ListOptionDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDropdownRepository extends JpaRepository<Select,Integer> {

        @Query(value = "select new com.nintriva.nms.payload.ListOptionDto(u.listId,u.options) from Select u where u.label=?1")
        List<ListOptionDto> getOptions(String label);


}
