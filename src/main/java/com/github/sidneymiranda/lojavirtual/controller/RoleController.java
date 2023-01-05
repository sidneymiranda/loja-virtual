package com.github.sidneymiranda.lojavirtual.controller;

import com.github.sidneymiranda.lojavirtual.dto.request.RoleRequestDTO;
import com.github.sidneymiranda.lojavirtual.dto.response.RoleResponseDTO;
import com.github.sidneymiranda.lojavirtual.service.impl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {
    private RoleService service;

    public RoleController() {
    }

    @Autowired
    public RoleController(RoleService service) {
        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasHole('ROLE_TESTER')")
    public ResponseEntity<RoleResponseDTO> saveRole(@Valid @RequestBody RoleRequestDTO roleRequestDTO) {
        RoleResponseDTO role = service.save(roleRequestDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/api/v1/roles/{id}")
                .buildAndExpand(role.getId())
                .toUri();

        return ResponseEntity.created(uri).body(role);
    }

    @GetMapping("/{authority}")
    public ResponseEntity<RoleResponseDTO> findByAuthority(@PathVariable String authority) {
        return ResponseEntity.ok().body(service.findByAuthority(authority));
    }

    @GetMapping
    public ResponseEntity<List<RoleResponseDTO>> findAll() {
        List<RoleResponseDTO> list = service.findAll();

        return list.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok().body(list);
    }
}
