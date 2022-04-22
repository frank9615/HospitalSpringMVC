package com.example.hospital.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Operator extends User {
    @OneToMany(mappedBy = "operator")
    private Set<Triage> triages;

    public Operator() {
    }

    public Set<Triage> getTriages() {
        return triages;
    }

    public void setTriages(Set<Triage> triages) {
        this.triages = triages;
    }
}
