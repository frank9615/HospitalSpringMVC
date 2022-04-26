package com.example.hospital.validator;

import com.example.hospital.entities.User;
import com.example.hospital.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserIdValidator implements ConstraintValidator<UserId, String> {

    @Autowired
    private IUserService userService;

    @Override
    public void initialize(UserId constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean res = false;
        User user = userService.findById(Long.valueOf(value));
        if (user != null) {
            res = true;
        }
        return res;
    }
}
