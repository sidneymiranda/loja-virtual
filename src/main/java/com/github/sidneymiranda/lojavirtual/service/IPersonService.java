package com.github.sidneymiranda.lojavirtual.service;

import com.github.sidneymiranda.lojavirtual.dto.request.PersonDto;
import com.github.sidneymiranda.lojavirtual.dto.response.PersonResponse;

public interface IPersonService {
    PersonResponse save(PersonDto person);
}
