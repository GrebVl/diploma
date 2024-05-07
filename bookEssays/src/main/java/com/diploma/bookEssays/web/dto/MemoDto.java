package com.diploma.bookEssays.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class MemoDto {

    @NotEmpty(message = "Id must be not null")
    private long id;

    @NotEmpty(message = "Title must be not null")
    private String topic;

    private String notion;

    private String description;

    private String conclusion;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime expirationDate;
}
