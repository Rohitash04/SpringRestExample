package com.practice.sample.model;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    private long id;
    private String name;
    private String shortDescription;
    private Author author;
    private Publication publication;
}
