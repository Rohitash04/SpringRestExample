package com.practice.sample.model;

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
public class Publication {
    String name;
    @Id
    String code;
    @ManyToOne
    @JoinColumn(name = "address_id")
    Address address;
}
