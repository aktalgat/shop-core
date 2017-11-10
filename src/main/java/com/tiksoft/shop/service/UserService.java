package com.tiksoft.shop.service;

import com.tiksoft.shop.model.User;

import java.nio.file.AccessDeniedException;
import java.util.List;

/**
 * Created by fan.jin on 2016-10-15.
 */
public interface UserService {
    User findById(Long id);
    User findByUsername(String username);
    List<User> findAll();// throws AccessDeniedException;
}
