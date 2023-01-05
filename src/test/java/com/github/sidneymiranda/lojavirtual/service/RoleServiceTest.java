package com.github.sidneymiranda.lojavirtual.service;

import com.github.sidneymiranda.lojavirtual.dto.request.RoleRequestDTO;
import com.github.sidneymiranda.lojavirtual.dto.response.RoleResponseDTO;
import com.github.sidneymiranda.lojavirtual.model.Role;
import com.github.sidneymiranda.lojavirtual.repository.RoleRepository;
import com.github.sidneymiranda.lojavirtual.service.impl.RoleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("RoleServiceTest")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(MockitoExtension.class)
class RoleServiceTest {

    private final RoleRepository repository;

    private final RoleService service;

    public RoleServiceTest() {
        this.repository = mock(RoleRepository.class);
        this.service = new RoleService(this.repository,  new ModelMapper());
    }

    @Test
    @DisplayName("deve salvar uma role")
    void whenSaveThenReturnOk() {
        String authority = "ROLE_USER";
        RoleRequestDTO roleRequestDTO = new RoleRequestDTO(authority);

        Role role = new Role();
        role.setAuthority("ROLE_USER");

        when(repository.save(ArgumentMatchers.any(Role.class))).thenReturn(role);
        RoleResponseDTO response = service.save(roleRequestDTO);

        verify(repository, Mockito.times(1)).save(ArgumentMatchers.any(Role.class));
        assertEquals(roleRequestDTO.getAuthority(), response.getAuthority());
        assertInstanceOf(RoleResponseDTO.class, response);
    }

    @Test
    @DisplayName("deve retornar uma exceção ao tentar salvar uma role sem uma authority")
    void whenAuthorityNullThenNoSave() {
        Throwable throwable = assertThrowsExactly(
                RuntimeException.class, () -> service.save(new RoleRequestDTO("ROLE_USER")));

        assertEquals("Campo authority não pode ser nulo.", throwable.getLocalizedMessage());
    }

    @Test
    @DisplayName("deve retornar uma role buscando pela authority")
    void whenFindThenReturnOk() {
        Role role = new Role();
        role.setAuthority("ROLE_ADMIN");

        when(repository.findByAuthority(ArgumentMatchers.any(String.class))).thenReturn(Optional.of(role));
        RoleResponseDTO response = service.findByAuthority("ROLE_ADMIN");

        verify(repository, times(1)).findByAuthority(ArgumentMatchers.any(String.class));
        assertEquals("ROLE_ADMIN", response.getAuthority());
    }

    @Test
    @DisplayName("deve retornar uma lista de roles")
    void whenFindAllWhenOk() {
        List<Role> roles = new ArrayList<>();
        roles.add(new Role());
        roles.add(new Role());
        roles.add(new Role());
        when(repository.findAll()).thenReturn(roles);

        List<RoleResponseDTO> list = service.findAll();

        assertEquals(3, list.size());
    }

    @Test
    @DisplayName("deve remover uma role")
    void whenDeleteThenOk() {
        String authority = "ROLE_ADMIN";
        RoleRequestDTO roleRequestDTO = new RoleRequestDTO(authority);

        Role role = new Role();
        role.setAuthority("ROLE_ADMIN");

        when(repository.findByAuthority(any(String.class))).thenReturn(Optional.of(role));
        final RoleResponseDTO findRole = service.findByAuthority(roleRequestDTO.getAuthority());
        assertNotNull(findRole);

//      doNothing().when(repository).delete(role);
        service.delete(roleRequestDTO);
        when(repository.findByAuthority(any(String.class))).thenReturn(Optional.empty());
        verify(repository, times(1)).delete(ArgumentMatchers.any(Role.class));
//        assertThrowsExactly(NoSuchElementException.class, () -> service.findByAuthority(roleRequestDTO.getAuthority()));
    }
}