package com.surittec.desafio.services.mapper;

import com.surittec.desafio.domain.Cliente;
import com.surittec.desafio.services.dto.ClienteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface ClienteMapper extends EntityMapper<ClienteDTO, Cliente> {

}