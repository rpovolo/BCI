package com.bci.user.services.impl;

import com.bci.user.dto.User;
import com.bci.user.dto.UserResponse;
import com.bci.user.entity.UserEntity;
import com.bci.user.mapper.PhoneMapper;
import com.bci.user.mapper.UserMapper;
import com.bci.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserMapper userMapper;
    @Mock
    private PhoneMapper phoneMapper;
    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void testGetAll() {

        List<UserEntity> entities = new ArrayList<>();
        entities.add(new UserEntity());
        when(userRepository.findAll()).thenReturn(entities);

        List<UserResponse> responses = userService.getAll();

        assertEquals(entities.size(), responses.size());
    }

    @Test
    void testGetById() {

        String id = UUID.randomUUID().toString();
        UserEntity entity = new UserEntity();
        when(userRepository.findById(id)).thenReturn(Optional.of(entity));
        when(userMapper.toUserResponse(entity)).thenReturn(new UserResponse());

        Optional<UserResponse> response = userService.getById(id);

        assertTrue(response.isPresent());
    }

    @Test
    void testDelete() {

        String id = UUID.randomUUID().toString();
        UserEntity entity = new UserEntity();
        when(userRepository.findById(id)).thenReturn(Optional.of(entity));

        userService.delete(id);

        verify(userRepository).delete(entity);
    }
}