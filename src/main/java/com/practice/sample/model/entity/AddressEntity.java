package com.practice.sample.model.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Address")
public class AddressEntity {
    @Id
    Long id;
    String houseNumber;
    String street;
    String city;
    String zipCode;
    String country;
}
