package com.example.person.domain;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class PersonRequestDto {
    private final String name;
    private final Long age;
}
