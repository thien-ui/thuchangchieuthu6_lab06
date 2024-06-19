package com.example.demo.Validator;

import com.example.demo.repository. IuserRepository;
import com.example.demo.Validator.annotation.ValidUsername;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
public class ValidUsernameValidator implements ConstraintValidator<ValidUsername, String> {
    @Autowired
    private IuserRepository userRepository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {

        if (userRepository == null)
            return true;
        return userRepository.findByUserName(username) == null;
    }
}
