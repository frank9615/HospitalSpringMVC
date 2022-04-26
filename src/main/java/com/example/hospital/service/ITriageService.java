package com.example.hospital.service;

import com.example.hospital.entities.Triage;

import java.util.List;

public interface ITriageService {
    Triage findById(Long id);

    void save(Triage triage);

    void update(Triage triage);

    void delete(Triage triage);

    List<Triage> getByDoctorId(Long id);

    List<Triage> getByPatientId(Long id);

    List<Triage> getByOperatorId(Long id);

}
