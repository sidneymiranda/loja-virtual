package com.github.sidneymiranda.lojavirtual.service.impl;

import com.github.sidneymiranda.lojavirtual.dto.request.RoleRequestDTO;
import com.github.sidneymiranda.lojavirtual.dto.response.RoleResponseDTO;
import com.github.sidneymiranda.lojavirtual.model.Role;
import com.github.sidneymiranda.lojavirtual.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final ModelMapper mapper;


    public RoleService(RoleRepository roleRepository, ModelMapper mapper) {
        this.roleRepository = roleRepository;
        this.mapper = mapper;
    }
    private RoleResponseDTO mapperToDTO(Role role) {
        return mapper.map(role, RoleResponseDTO.class);
    }

    private Role mapperToEntity(RoleRequestDTO roleRequestDTO) {
        return mapper.map(roleRequestDTO, Role.class);
    }

    public RoleResponseDTO save(RoleRequestDTO roleRequestDTO) {
        Role roleResponse = roleRepository.save(mapperToEntity(roleRequestDTO));
        return mapperToDTO(roleResponse);
    }

    public RoleResponseDTO findByAuthority(String authority) {
        return roleRepository.findByAuthority(authority)
                .map(this::mapperToDTO)
                .orElseThrow(NoSuchElementException::new);
    }

    public List<RoleResponseDTO> findAll() {
        return roleRepository.findAll().stream()
                .map(this::mapperToDTO)
                .collect(Collectors.toList());
    }

    public void delete(RoleRequestDTO roleRequestDTO) {
        roleRepository.delete(mapperToEntity(roleRequestDTO));
    }
}
