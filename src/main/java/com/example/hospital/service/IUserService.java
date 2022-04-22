package com.example.hospital.service;

import com.example.hospital.entities.User;

public interface IUserService {
    User findByUsername(String username);

    User findById(Long id);

    void save(User user);

    void update(User user);

    void delete(User user);
}
