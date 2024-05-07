package com.diploma.bookEssays.entity.memo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


/**
 * Сущность конспекта (заметки на определеную тему)
 */

@Entity
@Data
@NoArgsConstructor
@Table(name = "memos")
@AllArgsConstructor
public class Memo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "topic")
    private String topic;

    @Column(name = "notion")
    private String notion;

    @Column(name = "description")
    private String description;

    @Column(name = "conclusion")
    private String conclusion;
}