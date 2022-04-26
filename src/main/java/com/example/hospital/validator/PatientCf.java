package com.example.hospital.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = PatientCfValidator.class)
@Documented
public @interface PatientCf {
    public String message() default "Invalid CF";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
