package com.tiksoft.shop.dao.repository;

import com.tiksoft.shop.dao.model.User;

import java.util.List;

/**
 * Created by Talgat on 2017-11-03.
 */

public interface UserRepository {
    User findByUsername(String username);
    User findOne(Long id);
    List<User> findAll();
    void save(User user);
    User findById(Long id);
}

