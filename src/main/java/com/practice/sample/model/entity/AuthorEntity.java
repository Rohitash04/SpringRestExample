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
@Table(name = "Author")
public class AuthorEntity {
    @Id
    long id;
    String name;
    @ManyToOne
    @JoinColumn(name = "address_id")
    AddressEntity address;
}
