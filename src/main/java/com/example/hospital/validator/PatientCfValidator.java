package com.example.hospital.validator;

import com.example.hospital.entities.Patient;
import com.example.hospital.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PatientCfValidator implements ConstraintValidator<PatientCf, String> {

    @Autowired
    private IPatientService patientService;

    @Override
    public void initialize(PatientCf constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean res = false;
        Patient patient = patientService.findByCF(value);
        if(patient != null) {
            res = true;
        }
        return res;
    }
}
