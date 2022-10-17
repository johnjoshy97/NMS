    package com.nintriva.nms.entity;

    import lombok.Data;

    import javax.persistence.*;
    import java.util.UUID;

    @Entity
    @Data
    @Table(name = "user_entity")
    public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

        private String userid;
        private String firstname;
        private String lastname;
        private String email;
        private String username;
    }

