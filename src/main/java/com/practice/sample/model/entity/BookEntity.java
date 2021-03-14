package com.practice.sample.model.entity;

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
public class BookEntity {
    @Id
    private long id;
    private String name;
    private String shortDescription;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorEntity authorEntity;

    @ManyToOne
    @JoinColumn(name = "code")
    private PublicationEntity publicationEntity;
}
