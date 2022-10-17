    package com.nintriva.nms.entity;

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
        private long roleid;


        @Column(length = 60)
        private String roleName;

    }