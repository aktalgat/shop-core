package com.tiksoft.shop.dao.repository;

import com.tiksoft.shop.dao.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by fan.jin on 2016-10-15.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

