package com.nintriva.nms.service.impl;

import com.nintriva.nms.payload.ListOptionDto;
import com.nintriva.nms.repository.UserDropdownRepository;
import com.nintriva.nms.service.ListOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListOptionServiceImpl implements ListOptionService {

    @Autowired
    private UserDropdownRepository userDropdownRepository;
    @Override
    public List<ListOptionDto> insertOption(String label) {

        List<ListOptionDto> options = userDropdownRepository.getOptions(label);

        return options;
    }
    }


