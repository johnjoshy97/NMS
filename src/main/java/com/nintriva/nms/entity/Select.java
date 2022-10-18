package com.nintriva.nms.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Nms_select")
public class Select {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int selectId;
    private String label;
    private String options;
}
