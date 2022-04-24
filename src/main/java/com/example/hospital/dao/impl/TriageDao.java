package com.example.hospital.dao.impl;

import com.example.hospital.dao.AbstractDao;
import com.example.hospital.dao.ITriageDao;
import com.example.hospital.entities.Triage;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class TriageDao extends AbstractDao<Triage, Long> implements ITriageDao {
    @Override
    public List<Triage> getByDoctorId(Long id) {
        return this.getByPropertyID(id, "doctor_id");
    }

    @Override
    public List<Triage> getByPatientId(Long id) {
        return this.getByPropertyID(id, "patient_id");
    }

    @Override
    public List<Triage> getByOperatorId(Long id) {
        return this.getByPropertyID(id, "operator_id");
    }

    private List<Triage> getByPropertyID(Long id, String property){
        List<Triage> triages;
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Triage> query = cb.createQuery(Triage.class);
        Root<Triage> root = query.from(Triage.class);
        query.select(root).where(cb.equal(root.get(property), id));
        triages = entityManager.createQuery(query).getResultList();
        return triages;
    }
}
