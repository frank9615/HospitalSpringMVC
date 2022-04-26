package com.example.hospital.domain;

import com.example.hospital.enums.TriageColor;
import com.example.hospital.validator.PatientCf;
import com.example.hospital.validator.UserId;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class TriageDomain implements Serializable {
    @NotEmpty(message = "Inserisci un codice fiscale")
    @PatientCf(message = "Codice fiscale non valido")
    private String cf;

    @NotNull
    private TriageColor triageColor;

    @NotNull(message ="Utente non valido")
    private Long doctor_id;

    @NotEmpty(message = "Nota non valida")
    private String notes;

    public TriageDomain() {

    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public TriageColor getTriageColor() {
        return triageColor;
    }

    public void setTriageColor(TriageColor triageColor) {
        this.triageColor = triageColor;
    }

    public Long getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Long doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "TriageDomain{" +
                "cf='" + cf + '\'' +
                ", triageColor=" + triageColor +
                ", doctor_id=" + doctor_id +
                ", notes='" + notes + '\'' +
                '}';
    }
}
