package com.nintriva.repository.NMS.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long role_id;


    @Column(length = 60)
    private String role_name;

//    @ManyToMany(mappedBy = "role")
//    private Set<User> users;
}