package com.example.hospital.controller;


import com.example.hospital.entities.Patient;
import com.example.hospital.response.PatientResponse;
import com.example.hospital.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/operator/")
public class OperatorPanelController {

    @Autowired
    private IPatientService patientService;

    @GetMapping("/operatorPanel")
    public String getOperatorPanel(Model model){
        return "operator/operatorPanel";
    }

    /* MediaType.APPLICATION_JSON_VALUE -> Is a String equivalent of APPLICATION_JSON. */
    @PostMapping(value = "/savePatient", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public PatientResponse savePatient(@ModelAttribute @Valid Patient patient, BindingResult result){
        PatientResponse response = new PatientResponse();
        if(result.hasErrors()){
            Map<String, String> errors = result.getFieldErrors().stream().collect(
                    Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            response.setValidated(false);
            response.setErrorMessages(errors);
        }else{
            response.setValidated(true);
            patient.setRegistrationDate(new Date());
            this.patientService.save(patient);
        }
    return response;
    }

    @InitBinder
    public void initialiseBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, "birthday", new CustomDateEditor(dateFormat, true));
        binder.setAllowedFields("cf", "name", "surname", "birthday");
    }
}
