package com.practice.sample.model;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    Long id;
    String houseNumber;
    String street;
    String city;
    String zipCode;
    String country;
}
