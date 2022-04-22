package com.example.hospital.dao.impl;

import com.example.hospital.dao.AbstractDao;
import com.example.hospital.dao.IUserDao;
import com.example.hospital.entities.User;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class UserDao extends AbstractDao<User, Long> implements IUserDao {


    @Override
    public User findByUsername(String username) {
        User user = null;
        try{
            CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<User> queryDefinition = queryBuilder.createQuery(User.class);
            Root<User> recordset = queryDefinition.from(User.class);

            queryDefinition.select(recordset).
                    where(queryBuilder.equal(recordset.get("username"), username));
            user = entityManager.createQuery(queryDefinition).getSingleResult();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return user;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }
}
