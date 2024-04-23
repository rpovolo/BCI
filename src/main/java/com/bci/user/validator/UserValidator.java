package com.bci.user.validator;

import com.bci.user.dto.User;
import com.bci.user.entity.UserEntity;
import com.bci.user.exception.InternalErrorException;
import com.bci.user.repository.UserRepository;
import lombok.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Pattern;

@Component
public class UserValidator {
    private final UserRepository userRepository;
    private static final String PROPERTY_COUCHBASE_LOCATION = "email.validation.regex";
    @Resource
    private Environment env;

    public UserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validateOrFail(User user) {
        validateIfExistEmail(user.getEmail());
        if (!validateRegularExpressionEmail(user.getEmail())){
            throw new InternalErrorException("Invalid email format.");
        }
    }

    private void validateIfExistEmail(String email){
        Optional<UserEntity> userFound = userRepository.findAll().stream().filter(user -> user.getEmail().equals(email)).findFirst();
        if (userFound.isPresent()){
            throw new InternalErrorException("Email already exists.");
        }
    }

    private boolean validateRegularExpressionEmail(String email){
        Pattern pattern = Pattern.compile(Objects.requireNonNull(env.getProperty(PROPERTY_COUCHBASE_LOCATION)));
        return pattern.matcher(email).matches();
    }

}
