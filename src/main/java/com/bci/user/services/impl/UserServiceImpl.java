package com.bci.user.services.impl;

import com.bci.user.dto.User;
import com.bci.user.dto.UserResponse;
import com.bci.user.entity.UserEntity;
import com.bci.user.exception.InternalErrorException;
import com.bci.user.mapper.PhoneMapper;
import com.bci.user.mapper.UserMapper;
import com.bci.user.repository.UserRepository;
import com.bci.user.services.UserService;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper = Mappers.getMapper(UserMapper.class);
    private final PhoneMapper mapperPhone =  Mappers.getMapper(PhoneMapper.class);

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponse> getAll() {
        return mapper.toUserResponses(userRepository.findAll());
    }

    @Override
    public Optional<UserResponse> getById(String id) {
        return userRepository.findById(id)
                .map(mapper::toUserResponse);
    }


    @Override
    public Optional<UserResponse> save(User user) {
        try {

            UserEntity userEntity = mapper.toUserEntity(user);
            userEntity.setId(UUID.randomUUID().toString());
            userEntity.setCreated(OffsetDateTime.now());
            userEntity.setLastLogin(userEntity.getCreated());
            userEntity.setInactive(false);
            userEntity.setEmail(userEntity.getEmail());
            userEntity.setToken(UUID.randomUUID().toString());
            userEntity = userRepository.save(userEntity);

            return Optional.ofNullable(mapper.toUserResponse(userEntity));
        } catch (Exception e) {
            throw new InternalErrorException(e.getMessage());
        }
    }

    @Override
    public Optional<UserResponse> update(String id, User user) {
        return userRepository.findById(id).map(entity -> {
            entity.setEmail(user.getEmail());
            entity.setPassword(user.getPassword());
            entity.setName(user.getName());

            entity.getPhones().clear();
            user.getPhones().stream()
                    .map(mapperPhone::convert)
                    .forEach(entity.getPhones()::add);

            return mapper.toUserResponse(userRepository.save(entity));
        });
    }

    @Override
    public void delete(String id) {
        Optional<UserEntity> entity = userRepository.findById(id);
        entity.ifPresent(userRepository::delete);
    }
}
