package com.github.sidneymiranda.lojavirtual.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.sidneymiranda.lojavirtual.annotations.WithMockTester;
import com.github.sidneymiranda.lojavirtual.dto.request.RoleRequestDTO;
import com.github.sidneymiranda.lojavirtual.dto.response.RoleResponseDTO;
import com.github.sidneymiranda.lojavirtual.service.impl.RoleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest
@ContextConfiguration(classes = RoleController.class)
class RoleControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private final ObjectMapper objectMapper = new ObjectMapper();;

    @MockBean
    private RoleService service;


    @Test
    @WithMockTester
    @DisplayName("deve fazer uma requisição POST e retornar o satus 201 CREATED")
    void whenPostRoleThen201Created() throws Exception {
        final String authority = "ROLE_DEVELOPER_BACKEND";

        RoleRequestDTO requestDTO = new RoleRequestDTO(authority);
        RoleResponseDTO responseDTO = new RoleResponseDTO(null, authority);

        when(service.save(any(RoleRequestDTO.class))).thenReturn(responseDTO);

        mockMvc
                .perform(post("/api/v1/roles")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestDTO))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.authority").value(authority));
    }
}