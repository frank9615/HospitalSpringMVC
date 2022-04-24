package com.example.hospital.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

@Entity
@DiscriminatorValue("DOCTOR")
public class Doctor extends User implements Serializable {
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

