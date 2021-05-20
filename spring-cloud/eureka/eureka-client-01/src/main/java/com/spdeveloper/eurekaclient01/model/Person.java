package com.spdeveloper.eurekaclient01.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;



@RequiredArgsConstructor
@Data(staticConstructor = "of")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {
    String name;
    String family;
}

