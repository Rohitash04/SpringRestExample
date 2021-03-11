package com.practice.sample.model;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Book")
public class Book {
    @Id
    private long id;
    private String name;
    private String shortDescription;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "code")
    private Publication publication;
}
