package com.example.hospital.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Patient {
    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    @Basic
    @Column(unique = true)
    private String cf;
    @Basic
    private String name;
    @Basic
    private String surname;
    @Temporal(TemporalType.DATE)
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
}
