package com.itsupport.backend.mapper;

import com.itsupport.backend.dto.AuthUserDTO;
import com.itsupport.backend.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(AuthUserDTO authUserDTO);
    AuthUserDTO toDTO( User user );
}
