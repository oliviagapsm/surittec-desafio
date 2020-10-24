package com.surittec.desafio.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.surittec.desafio.domain.User;
import com.surittec.desafio.services.dto.UserDTO;
import com.surittec.desafio.services.dto.UserNewDTO;
import com.surittec.desafio.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @ApiOperation(value = "Busca Todos os Users")
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAllDTO());
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @ApiOperation(value = "Busca por um User pelo seu id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(service.findByIdDTO(id));
    }


    @ApiOperation(value = "insere um novo User")
    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody UserNewDTO objDTO) {
        UserDTO obj = service.insertDTO(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @ApiOperation(value = "Atualiza um User")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Valid @PathVariable Integer id, @RequestBody UserNewDTO objDTO) {
        service.update(objDTO, id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @ApiOperation(value = "Deleta um User")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
