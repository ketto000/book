package com.cos.book.domain;


import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class portfolio {
    private int idx;

    private String start_date;

    private String deadline;

    private String header;

    private String description;

    private String image_path;
}