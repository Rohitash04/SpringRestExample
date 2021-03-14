package com.practice.sample.model.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Publication")
public class PublicationEntity {
    String name;
    @Id
    String code;
    @ManyToOne
    @JoinColumn(name = "address_id")
    AddressEntity address;
}
