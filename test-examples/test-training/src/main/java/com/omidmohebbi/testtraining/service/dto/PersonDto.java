package com.omidmohebbi.testtraining.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PersonDto {

    private Long id;
    private String name;
    private String family;
    private short age;
}
