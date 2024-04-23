package com.bci.user.services;

import com.bci.user.dto.User;
import com.bci.user.dto.UserResponse;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserResponse> getAll();
    Optional<UserResponse> getById (String id);
    Optional<UserResponse> save (User user);
    Optional<UserResponse> update (String id, User user);
    void delete(String id);

}
