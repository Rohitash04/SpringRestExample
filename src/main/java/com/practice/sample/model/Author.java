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
@Table(name = "Author")
public class Author {
    @Id
    long id;
    String name;
    @ManyToOne
    @JoinColumn(name = "address_id")
    Address address;
}
