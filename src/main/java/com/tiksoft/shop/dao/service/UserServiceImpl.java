package com.tiksoft.shop.dao.service;

import com.tiksoft.shop.dao.repository.UserRepository;
import com.tiksoft.shop.dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username ) throws UsernameNotFoundException {
        return userRepository.findByUsername( username );
    }

    public User findById( Long id ) {
        return userRepository.findOne( id );
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}