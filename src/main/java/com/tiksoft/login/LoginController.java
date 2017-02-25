package com.tiksoft.login;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Talgat on 25.02.2017.
 */

@RestController
public class LoginController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(
            path = "/login",
            method = RequestMethod.POST,
            produces = "application/json"
    )
    public Result authorize(@RequestParam(value = "login") String login,
                            @RequestParam(value = "password") String password) {
        return new Result(counter.incrementAndGet(), login + " "  + password);
    }
}
