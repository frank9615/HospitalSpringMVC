package com.example.hospital.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Doctor extends User{
    @OneToMany(mappedBy = "doctor")
    private Set<Triage> triages;

    public Doctor() {
    }

    public Set<Triage> getTriages() {
        return triages;
    }

    public void setTriages(Set<Triage> triages) {
        this.triages = triages;
    }
}

