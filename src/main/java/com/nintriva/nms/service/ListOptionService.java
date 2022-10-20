package com.nintriva.nms.service;

import com.nintriva.nms.payload.ListOptionDto;
import com.nintriva.nms.response.Response;

import javax.swing.*;
import java.util.List;


public interface ListOptionService {
   List<ListOptionDto> insertOption(String label) ;
}


