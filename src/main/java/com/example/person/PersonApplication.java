package com.example.person;

import com.example.person.domain.Person;
import com.example.person.domain.PersonRepository;
import com.example.person.service.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class PersonApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(PersonRepository personRepository, PersonService personService) {
        return (args) -> {
            personRepository.save(new Person("유승근", 26L));
            List<Person> perosnList = personRepository.findAll();
            for (int i = 0; i < perosnList.size(); i++) {
                Person person = perosnList.get(i);
                System.out.println(person.getId());
                System.out.println(person.getName());
                System.out.println(person.getAge());
            }
        };
    }


}
