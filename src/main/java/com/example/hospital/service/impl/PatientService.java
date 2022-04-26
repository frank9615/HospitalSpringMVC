package com.example.hospital.service.impl;

import com.example.hospital.dao.IPatientDao;
import com.example.hospital.entities.Patient;
import com.example.hospital.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service("patientService")
@Transactional
public class PatientService implements IPatientService {

    @Autowired
    private IPatientDao patientDao;

    @Override
    public Patient findByCF(String cf) {
        return this.patientDao.findByCF(cf);
    }

    @Override
    public Patient findById(Long id) {
        return this.patientDao.findById(id);
    }

    @Override
    public void save(Patient patient) {
        this.patientDao.save(patient);

    }

    @Override
    public void update(Patient patient) {
        this.patientDao.update(patient);

    }

    @Override
    public void delete(Patient patient) {
        this.patientDao.delete(patient);

    }
}
