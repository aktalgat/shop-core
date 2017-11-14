package com.tiksoft.shop.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Talgat on 2017-11-03.
 */

public class Authority implements GrantedAuthority {
    private Long id;
    private String name;

    public Authority(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public String getName() {
        return name;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "role: " + name;
    }
}
