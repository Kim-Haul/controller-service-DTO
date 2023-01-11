package com.example.person.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor // 기본생성자를 대신 생성해줍니다.
@Getter
@Entity // 테이블임을 나타냅니다.
public class Person extends Timestamped{

    @Id // ID 값, Primary Key 로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령입니다.
    private Long id;

    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
    private String name;

    @Column(nullable = false)
    private Long age;

    // 새로운 객체 생성시 필요한 기본 생성자
    public Person(String name, Long age) {
        this.name = name;
        this.age = age;
    }

    // Dto 를 통한 PostMapping (업데이트)를 위한 생성자
    public Person(PersonRequestDto requestDto) {
        this.name = requestDto.getName();
        this.age = requestDto.getAge();
    }

    // 업데이트
    public void update(PersonRequestDto requestDto) {
        this.name = requestDto.getName();
        this.age = requestDto.getAge();
    }

}
