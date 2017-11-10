package com.tiksoft.shop.service;

import com.tiksoft.shop.model.User;
import com.tiksoft.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username ) throws UsernameNotFoundException {
        User u = userRepository.findByUsername( username );
        return u;
    }

    public User findById( Long id ) {
        User u = userRepository.findOne( id );
        return u;
    }

    public List<User> findAll() {
        List<User> result = userRepository.findAll();
        return result;
    }
}