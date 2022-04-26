package com.example.hospital.dao.impl;

import com.example.hospital.dao.AbstractDao;
import com.example.hospital.dao.IPatientDao;
import com.example.hospital.entities.Patient;
import org.springframework.stereotype.Repository;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class PatientDao extends AbstractDao<Patient, Long>  implements IPatientDao {
    @Override
    public Patient findByCF(String cf) {
        Patient patient = null;
        try{
            CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Patient> queryDefinition = queryBuilder.createQuery(Patient.class);
            Root<Patient> recordset = queryDefinition.from(Patient.class);
            queryDefinition.select(recordset).
                    where(queryBuilder.equal(recordset.get("cf"), cf));
            patient = entityManager.createQuery(queryDefinition).getSingleResult();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return patient;
    }


}
