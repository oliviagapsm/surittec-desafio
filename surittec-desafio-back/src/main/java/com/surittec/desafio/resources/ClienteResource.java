package com.surittec.desafio.resources;

import com.surittec.desafio.services.ClienteService;
import com.surittec.desafio.services.dto.ClienteDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @ApiOperation(value = "Listar todos os clientes")
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll() {
        return ResponseEntity.ok().body(clienteService.findAll());
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @ApiOperation(value = "Listar cliente pelo id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(clienteService.findById(id));
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @ApiOperation(value = "Inserir um novo cliente")
    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody ClienteDTO obj) {
        clienteService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @ApiOperation(value = "Atualizar um cliente")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody ClienteDTO obj) {
        clienteService.update(obj, id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @ApiOperation(value = "Deletar um cliente")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
