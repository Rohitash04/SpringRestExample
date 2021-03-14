package com.practice.sample.model;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {
    long id;
    String name;
    Address address;
}
