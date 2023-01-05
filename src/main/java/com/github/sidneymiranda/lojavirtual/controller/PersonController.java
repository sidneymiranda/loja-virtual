package com.github.sidneymiranda.lojavirtual.controller;

import com.github.sidneymiranda.lojavirtual.dto.request.PersonDto;
import com.github.sidneymiranda.lojavirtual.dto.response.PersonResponse;
import com.github.sidneymiranda.lojavirtual.service.IPersonService;
import com.github.sidneymiranda.lojavirtual.service.impl.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {
    private final IPersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<PersonResponse> savePerson(@Valid @RequestBody PersonDto person) {
        return new ResponseEntity<>(service.save(person), HttpStatus.CREATED);
    }
}
