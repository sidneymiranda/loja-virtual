package com.github.sidneymiranda.lojavirtual.dto.request;

import com.github.sidneymiranda.lojavirtual.model.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PersonDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String email;

    private String phone;

    private List<Address> addresses;
}
