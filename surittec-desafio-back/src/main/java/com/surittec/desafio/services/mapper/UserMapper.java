package com.surittec.desafio.services.mapper;

import com.surittec.desafio.domain.User;
import com.surittec.desafio.services.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface UserMapper extends EntityMapper<UserDTO, User> {
}