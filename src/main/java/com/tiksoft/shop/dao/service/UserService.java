package com.tiksoft.shop.dao.service;

import com.tiksoft.shop.dao.model.User;

import java.util.List;

public interface UserService {
    User findByUsername(String username);
    List<User> findAll();
    User findById(Long id);
}
