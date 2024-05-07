package com.diploma.bookEssays.web.mapper;

import com.diploma.bookEssays.entity.user.User;
import com.diploma.bookEssays.web.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends Mappable<User, UserDto> {
}
