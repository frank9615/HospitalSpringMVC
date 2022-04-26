package com.example.hospital.service.impl;

import com.example.hospital.dao.IUserDao;
import com.example.hospital.entities.Doctor;
import com.example.hospital.entities.Operator;
import com.example.hospital.entities.User;
import com.example.hospital.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("userService")
@Transactional
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User findById(Long id) {
        return this.userDao.findById(id);
    }

    @Override
    public void save(User user) {
        this.userDao.save(user);
    }

    @Override
    public void update(User user) {
        this.userDao.update(user);
    }

    @Override
    public void delete(User user) {
        this.userDao.delete(user);
    }

    @Override
    public Doctor getDoctorByUsername(String username) {
        return this.userDao.getDoctorByUsername(username);
    }

    @Override
    public Operator getOperatorByUsername(String username) {
        return this.userDao.getOperatorByUsername(username);
    }
}
