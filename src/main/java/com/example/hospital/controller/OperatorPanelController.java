package com.example.hospital.controller;


import com.example.hospital.config.security.SpringSecurityUserContext;
import com.example.hospital.entities.*;
import com.example.hospital.response.PatientResponse;
import com.example.hospital.service.IPatientService;
import com.example.hospital.service.ITriageService;
import com.example.hospital.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
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

    @Autowired
    private IUserService userService;

    @Autowired
    private ITriageService triageService;

    @GetMapping("/operatorPanel")
    public String getOperatorPanel(Model model){
        String currentUser =  new SpringSecurityUserContext().getCurrentUser();
        model.addAttribute("user", currentUser);
        return "operator/operatorPanel";
    }

    @PostMapping(value = "/savePatient", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public PatientResponse savePatient(@ModelAttribute @Valid Patient patient, BindingResult result){
        PatientResponse response = new PatientResponse();

        System.out.println("Paziente registrato " + patient);
        if (result.hasErrors()) {
            Map<String, String> errors = result.getFieldErrors().stream().collect(
                    Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            response.setValidated(false);
            response.setErrorMessages(errors);
        } else {
            response.setValidated(true);
            patient.setRegistrationDate(new Date());
            this.patientService.save(patient);
        }

    return response;
    }

    /*
    @GetMapping(value="/addTriage")
    public String insTriage(Model model){
        List<User> doctors = this.userService.getAllDoctor();
        model.addAttribute("doctors", doctors);
        TriageDomain newTriage = new TriageDomain();
        model.addAttribute("newTriage", newTriage);
        return "operator/addTriage";
    }

    @PostMapping(value="/addTriage")
    public void addTriage(@Valid @ModelAttribute("newTriage") TriageDomain newTriage, BindingResult result, Model model){
        System.out.println(newTriage);

        Triage triage = new Triage();
        Patient patient = this.patientService.findByCF(newTriage.getCf());
        Operator operator = this.userService.getOperatorByUsername(new SpringSecurityUserContext().getCurrentUser());
        Doctor doctor = (Doctor) this.userService.findById(Long.valueOf(newTriage.getDoctor_id()));
        triage.setOperator(operator);
        triage.setDoctor(doctor);
        triage.setPatient(patient);
        triage.setNotes(newTriage.getNotes());
        triage.setTriageDate(new Date());
        triage.setTriageColor(newTriage.getTriageColor());
        triageService.save(triage);

    }
    */

    @InitBinder
    public void initialiseBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, "birthday", new CustomDateEditor(dateFormat, true));
        binder.setAllowedFields("cf", "name", "surname", "birthday");
    }
}
