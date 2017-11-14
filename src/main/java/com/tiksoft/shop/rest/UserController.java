package com.tiksoft.shop.rest;

import com.tiksoft.shop.dao.model.User;
import com.tiksoft.shop.dao.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by Talgat on 2017-11-03.
 */

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final Log log = LogFactory.getLog(this.getClass());
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping( method = GET, value = "/api/user/{userId}" )
    @PreAuthorize("hasRole('ADMIN')")
    public User loadById(@PathVariable Long userId ) {
        return this.userService.findById(userId);
    }

    @RequestMapping( method = GET, value= "/api/user/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> loadAll() {
        return this.userService.findAll();
    }


    /*
     *  We are not using userService.findByUsername here(we could),
     *  so it is good that we are making sure that the user has role "ROLE_USER"
     *  to access this endpoint.
     */
    @RequestMapping("/api/whoami")
    @PreAuthorize("hasRole('USER')")
    public User user(Principal user) {
        log.info("User in controller: " + user);
        return this.userService.findByUsername(user.getName());
    }
}
