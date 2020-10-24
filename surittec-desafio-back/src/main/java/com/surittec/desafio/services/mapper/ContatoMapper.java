package com.surittec.desafio.services.mapper;

import com.surittec.desafio.domain.Contato;
import com.surittec.desafio.domain.Endereco;
import com.surittec.desafio.services.dto.ContatoDTO;
import com.surittec.desafio.services.dto.EnderecoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface ContatoMapper extends EntityMapper<ContatoDTO, Contato> {

}