package com.cos.book.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;


//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Data
@Getter
@Setter
@Table(name="book")
@Accessors(chain = true)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="author")
    private String author;

    private String contents;

    private String filekey;

}
