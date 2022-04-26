package com.example.hospital.domain;

import com.example.hospital.enums.TriageColor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class TriageDomain implements Serializable {
    @NotEmpty(message = "Inserisci un codice fiscale")
    private String cf;

    @NotNull
    private String triageColor;

    @NotNull
    private Integer doctor_id;

    @NotEmpty(message = "Inserisci un valore")
    private String notes;

    public TriageDomain(){

    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public String getTriageColor() {
        return triageColor;
    }

    public void setTriageColor(String triageColor) {
        this.triageColor = triageColor;
    }

    public Integer getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Integer doctor_id) {
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
                ", triageColor='" + triageColor + '\'' +
                ", doctor_id=" + doctor_id +
                ", notes='" + notes + '\'' +
                '}';
    }
}
