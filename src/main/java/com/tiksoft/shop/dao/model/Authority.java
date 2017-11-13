package com.tiksoft.shop.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Talgat on 2017-11-03.
 */

//@Entity
//@Table(name="AUTHORITY")
public class Authority implements GrantedAuthority {

//    @Id
  //  @Column(name="id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name="name")
    private String name;

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

}
