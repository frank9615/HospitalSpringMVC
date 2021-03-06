package com.example.hospital.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

@Entity
@DiscriminatorValue("OPERATOR")
public class Operator extends User implements Serializable {
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
