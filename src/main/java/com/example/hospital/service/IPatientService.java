package com.example.hospital.service;

import com.example.hospital.entities.Patient;

import java.util.List;

public interface IPatientService {
    Patient findByCF(String cf);

    Patient findById(Long id);

    void save(Patient patient);

    void update(Patient patient);

    void delete(Patient patient);

    List<Patient> getAll();
}
