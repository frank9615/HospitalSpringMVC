package com.example.hospital.dao;

import com.example.hospital.entities.Triage;

import java.util.List;

public interface ITriageDao {
    Triage findById(Long id);
    List<Triage> getByDoctorId(Long id);
    List<Triage> getByPatientId(Long id);
    List<Triage> getByOperatorId(Long id);
    void save(Triage triage);
    void update(Triage triage);
    void delete(Triage triage);
}
