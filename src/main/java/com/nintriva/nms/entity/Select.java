package com.nintriva.nms.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Entity
@Data
@Table(name = "nms_list")
@NoArgsConstructor
@AllArgsConstructor
public class Select {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "list_id")
    private int listId;
    private String label;
    private String options;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(name = "created_by")
    private LocalDateTime createdBy;
    @Column(name = "updated_by")
    private LocalDateTime updatedBy;


}
