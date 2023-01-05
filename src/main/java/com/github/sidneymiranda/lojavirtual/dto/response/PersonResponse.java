package com.github.sidneymiranda.lojavirtual.dto.response;

import com.github.sidneymiranda.lojavirtual.model.Address;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class PersonResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String email;

    private String phone;

    private List<Address> addresses;

    @Override
    public String toString() {
        return "PersonResponse {" +
                "id:" + id +
                ", name:'" + name + '\'' +
                ", email:'" + email + '\'' +
                ", phone:'" + phone + '\'' +
                ", addresses:" + addresses +
                '}';
    }
}
