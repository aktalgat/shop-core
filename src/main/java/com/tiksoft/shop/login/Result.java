package com.tiksoft.shop.login;

/**
 * Created by Talgat on 25.02.2017.
 */
public class Result {

    private final long id;
    private final String message;

    Result(long id, String message) {
        this.id = id;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
