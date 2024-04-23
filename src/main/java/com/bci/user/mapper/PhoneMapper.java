package com.bci.user.mapper;

import com.bci.user.dto.Phone;
import com.bci.user.dto.User;
import com.bci.user.entity.PhoneEntity;
import com.bci.user.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface PhoneMapper {
    PhoneEntity convert(Phone model);
    User convert(UserEntity entity);

}
