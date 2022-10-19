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
@Table(name = "Nms_select")
@NoArgsConstructor
@AllArgsConstructor
public class Select {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int selectId;
    private String label;
    private String options;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
