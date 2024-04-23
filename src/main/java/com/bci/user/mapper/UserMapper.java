package com.bci.user.mapper;

import com.bci.user.dto.User;
import com.bci.user.dto.UserResponse;
import com.bci.user.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    UserEntity toUserEntity(User model);
    User toUser(UserEntity entity);
    UserResponse toUserResponse(UserEntity entity);
    List<UserResponse> toUserResponses(List<UserEntity> userResponses);
    List<UserEntity> toUserEntities(List<UserResponse> userResponses);

}
