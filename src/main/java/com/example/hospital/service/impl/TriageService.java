package com.example.hospital.service.impl;

import com.example.hospital.dao.ITriageDao;
import com.example.hospital.dao.IUserDao;
import com.example.hospital.entities.Triage;
import com.example.hospital.service.ITriageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("triageService")
@Transactional
public class TriageService implements ITriageService {

    @Autowired
    private ITriageDao triageDao;

    @Override
    public Triage findById(Long id) {
        return this.triageDao.findById(id);
    }

    @Override
    public void save(Triage triage) {
        this.triageDao.save(triage);
    }

    @Override
    public void update(Triage triage) {
        this.triageDao.update(triage);
    }

    @Override
    public void delete(Triage triage) {
        this.triageDao.delete(triage);
    }

    @Override
    public List<Triage> getByDoctorId(Long id) {
        return this.triageDao.getByDoctorId(id);
    }

    @Override
    public List<Triage> getByPatientId(Long id) {
        return this.triageDao.getByPatientId(id);
    }

    @Override
    public List<Triage> getByOperatorId(Long id) {
        return this.triageDao.getByOperatorId(id);
    }
}
