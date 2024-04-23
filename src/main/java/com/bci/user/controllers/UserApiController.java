package com.bci.user.controllers;

import com.bci.user.dto.UserResponse;
import com.bci.user.dto.User;
import com.bci.user.mapper.UserMapper;
import com.bci.user.services.UserService;
import com.bci.user.validator.UserValidator;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Generated;
import java.util.List;
import java.util.Optional;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-22T06:36:09.275717359-03:00[America/Argentina/Mendoza]")
@Controller
@RequestMapping("${openapi.aBMUsersAPIDefinition.base-path:/users/v1}")

public class UserApiController implements UserApi {

    private final UserService userServiceImpl;
    private final UserMapper mapper = Mappers.getMapper(UserMapper.class);
    private final UserValidator userValidator;

    public UserApiController(UserService userServiceImpl, UserValidator userValidator) {
        this.userServiceImpl = userServiceImpl;
        this.userValidator = userValidator;
    }

    @Override
    public ResponseEntity<UserResponse> createUser(String acceptLanguage, String accept, User user) {
        userValidator.validateOrFail(user);
        Optional<UserResponse> userResponse = userServiceImpl.save(user);
        return userResponse.map(response ->
                        ResponseEntity.status(HttpStatus.CREATED)
                                .body(response))
                .orElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @Override
    public ResponseEntity<Void> deleteUserById(String id, String acceptLanguage, String accept) {
        userServiceImpl.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<UserResponse> getUserById(String id, String acceptLanguage, String accept) {
        Optional<UserResponse> userFound = userServiceImpl.getById(id);
        return userFound.map(userResponse ->
                        ResponseEntity.ok(userResponse))
                .orElse(ResponseEntity.notFound().build());
    }


    @Override
    public ResponseEntity<List<UserResponse>> getUsers(String acceptLanguage, String accept) {
        return ResponseEntity.ok().body(userServiceImpl.getAll());
    }

    @Override
    public ResponseEntity<UserResponse> updateUserById(String id, String acceptLanguage, String accept, User user) {
        userValidator.validateOrFail(user);
        Optional<UserResponse> userResponse = userServiceImpl.update(id,user);
        return userResponse.map(response ->
                        ResponseEntity.status(HttpStatus.OK)
                                .body(response))
                .orElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

}
