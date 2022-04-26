package com.example.hospital.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
public class Patient implements Serializable {
    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    @Basic
    @Column(unique = true)
    @NotEmpty(message = "{NotEmpty.Patient.cf.validation}")
    private String cf;
    @Basic
    @NotEmpty(message = "{NotEmpty.Patient.name.validation}")
    private String name;
    @Basic
    @NotEmpty(message = "{NotEmpty.Patient.surname.validation}")
    private String surname;
    @Temporal(TemporalType.DATE)
    @Past
    @NotNull
    private Date birthday;
    @Temporal(TemporalType.DATE)
    private Date registrationDate;
    @OneToMany(mappedBy = "patient")
    private Set<Triage> triages;

    public Patient() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Set<Triage> getTriages() {
        return triages;
    }

    public void setTriages(Set<Triage> triages) {
        this.triages = triages;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", cf='" + cf + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
