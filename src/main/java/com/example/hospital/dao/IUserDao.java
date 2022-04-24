package com.example.hospital.dao;

import com.example.hospital.entities.User;

public interface IUserDao {
    User findByUsername(String username);
    User findById(Long id);
    void save(User user);
    void update(User user);
    void delete(User user);
}
