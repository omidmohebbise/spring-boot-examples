package com.example.eurekaclient.eurekaclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@ToString(includeFieldNames = true)
@RequiredArgsConstructor
@Data(staticConstructor = "of")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {
    String name;
    String family;
}

