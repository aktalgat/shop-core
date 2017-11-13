package com.tiksoft.shop.dao.repository;

import com.tiksoft.shop.dao.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Override
    public User findByUsername(String username) {
        return new User();
    }

    @Override
    public User findOne(Long id) {
        return new User();
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public User findById(Long id) {
        return null;
    }
}
