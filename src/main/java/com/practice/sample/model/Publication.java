package com.practice.sample.model;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Publication {
    String name;
    String code;
    Address address;
}
