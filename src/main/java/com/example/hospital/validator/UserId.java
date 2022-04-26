package com.example.hospital.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = UserIdValidator.class)
@Documented
public @interface UserId {
    String message() default "Invalid user id";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
