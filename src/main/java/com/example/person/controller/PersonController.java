package com.example.person.controller;

import com.example.person.domain.Person;
import com.example.person.domain.PersonRepository;
import com.example.person.domain.PersonRequestDto;
import com.example.person.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping
public class PersonController {

    private final PersonRepository personRepository;
    private final PersonService personService;

    // PostMapping 을 통해서, 같은 주소라도 방식이 다름을 구분합니다.
    @PostMapping("/api/persons")
    public Person createCourse(@RequestBody PersonRequestDto requestDto) {
        // @RequestBody 라는 어노테이션은 컨트롤러에서 요청을 받는 녀석이라는 걸 표시.
        // requestDto 는, 생성 요청을 의미.
        // 사람 info 를 만들기 위해서는 이름과 나이 이름이 필요하잖아?
        // 그 정보를 가져오는 녀석.

        // 저장하는 것은 Dto 가 아니라 Course 이니, Dto 의 정보를 course 에 담아야 함.
        // 잠시 뒤 새로운 생성자를 만듦.
        Person person = new Person(requestDto);

        // JPA 를 이용하여 DB에 저장하고, 그 결과를 반환.
        return personRepository.save(person);
    }

    @GetMapping("/api/persons")
    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    @PutMapping("/api/persons/{id}")
    public Long updateCourse(@PathVariable Long id, @RequestBody PersonRequestDto requestDto) {
        return personService.update(id, requestDto);
    }

    @DeleteMapping("/api/persons/{id}")
    public Long deleteCourse(@PathVariable Long id) {
        personRepository.deleteById(id);
        return id;
    }
}
