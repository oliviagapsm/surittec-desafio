package com.surittec.desafio.services;

import com.surittec.desafio.domain.Cliente;
import com.surittec.desafio.repositoties.ClienteRepository;
import com.surittec.desafio.services.dto.ClienteDTO;
import com.surittec.desafio.services.exceptions.ObjectNotFoundException;
import com.surittec.desafio.services.mapper.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;
    
    public Integer insert(ClienteDTO objDTO) {
        objDTO.setId(null);
        Cliente obj = save(objDTO);
        return obj.getId();
    }

    public ClienteDTO update(ClienteDTO objDTO, Integer id) {
        objDTO.setId(id);
        this.save(objDTO);
        return objDTO;
    }

    private Cliente save(ClienteDTO objDTO) {
        Cliente obj = clienteMapper.toEntity(objDTO);
        clienteRepository.save(obj);
        return obj;
    }

    public List<ClienteDTO> findAll() {
        List<Cliente> listObj = this.clienteRepository.findAll();
        return clienteMapper.toDto(listObj);
    }

    public ClienteDTO findById(Integer id) {
        Cliente obj = clienteRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Registro não encontrado"));
        return clienteMapper.toDto(obj);
    }

    public void delete(Integer id) {
        findById(id);
        clienteRepository.deleteById(id);
    }
}
