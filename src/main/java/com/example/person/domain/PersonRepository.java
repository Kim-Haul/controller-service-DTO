package com.example.person.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    // Person 이라는 녀석의 id 의 형태가 Long 이다.

    // JPA 는 Repository 에서만, 즉 interface 에서만 사용이 가능하고
    // interface 는 클래스에서 멤버가 빠진, 메소드의 모음집이라고 생각.
}
