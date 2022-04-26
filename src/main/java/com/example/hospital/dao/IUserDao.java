package com.example.hospital.dao;

import com.example.hospital.entities.Doctor;
import com.example.hospital.entities.Operator;
import com.example.hospital.entities.User;

public interface IUserDao {
    User findByUsername(String username);
    User findById(Long id);
    void save(User user);
    void update(User user);
    void delete(User user);
    Doctor getDoctorByUsername(String username);
    Operator getOperatorByUsername(String username);
}
