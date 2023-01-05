package com.github.sidneymiranda.lojavirtual.service.impl;

import com.github.sidneymiranda.lojavirtual.dto.request.LegalPersonDto;
import com.github.sidneymiranda.lojavirtual.dto.request.PersonDto;
import com.github.sidneymiranda.lojavirtual.dto.request.PhysicalPersonDto;
import com.github.sidneymiranda.lojavirtual.dto.response.LegalPersonResponse;
import com.github.sidneymiranda.lojavirtual.dto.response.PersonResponse;
import com.github.sidneymiranda.lojavirtual.dto.response.PhysicalPersonResponse;
import com.github.sidneymiranda.lojavirtual.model.Person;
import com.github.sidneymiranda.lojavirtual.repository.PersonRepository;
import com.github.sidneymiranda.lojavirtual.service.IPersonService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PersonService implements IPersonService {
    private final PersonRepository repository;
    private final ModelMapper mapper;

    public PersonService(PersonRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public PersonResponse save(PersonDto person) {
        Person response = repository.save(mapper.map(person, Person.class));
        log.info("Person saved success!");

        PersonResponse personResponse = new PersonResponse();

        if(person instanceof LegalPersonDto) {
            personResponse = mapper.map(response, LegalPersonResponse.class);
        } else if (person instanceof PhysicalPersonDto) {
            personResponse = mapper.map(response, PhysicalPersonResponse.class);
        }

        log.info("Person response :: {}", personResponse.toString());

        return personResponse;
    }
}
