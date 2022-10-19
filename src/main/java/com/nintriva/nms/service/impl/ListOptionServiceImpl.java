package com.nintriva.nms.service.impl;

import com.nintriva.nms.entity.Select;
import com.nintriva.nms.payload.ListOptionDto;
import com.nintriva.nms.repository.UserDropdownRepository;
import com.nintriva.nms.response.Response;
import com.nintriva.nms.service.ListOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class ListOptionServiceImpl implements ListOptionService {

    @Autowired
    private UserDropdownRepository userDropdownRepository;

    public Response insertOption(ListOptionDto listOptionDto){

        userDropdownRepository.ListOptions(listOptionDto.getLabel());

        return Response.builder().success(true).message("option inserted").statusCode(HttpStatus.CREATED).data(listOptionDto.getLabel()).build();
    }
    }


