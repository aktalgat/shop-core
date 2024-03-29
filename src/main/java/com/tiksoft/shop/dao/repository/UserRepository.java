package com.tiksoft.shop.dao.repository;

import com.tiksoft.shop.dao.model.User;

import java.util.List;

/**
 * Created by Talgat on 2017-11-03.
 */

public interface UserRepository {
    User findByUsername(String username);
    List<User> findAll();
    void save(User user);
    User findById(Long id);
}