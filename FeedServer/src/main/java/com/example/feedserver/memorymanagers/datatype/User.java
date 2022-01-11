package com.example.feedserver.memorymanagers.datatype;

import com.example.feedserver.helpers.Idable;

import java.util.Date;
import java.util.regex.Pattern;

public class User implements Idable {
    private final String username;
    private final String password;
    private final String email;
    private final String id;
    private final Date creationTime;

    private static final String EMAIL_REGEX = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    // TODO: 29/11/2021 maybe save a pointer to the pattern

    public User(String username, String password, String email) throws Exception {
        if (emailIsValid(email)) {
            this.email = email;
        } else {
            // TODO: 29/11/2021 create custom exception
            throw new Exception();
        }
        this.username = username;
        this.password = password;
        this.id = generateId();
        this.creationTime = new Date();
    }

    private User(String username, String password, String email, Date creationTime) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.id = generateId();
        this.creationTime = creationTime;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.email = null;
        this.id = generateId();
        this.creationTime = new Date();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public Date getCreationTime() {
        return creationTime;
    }
    //    private boolean emailIsValid(String email) {
//        Pattern pattern = Pattern.compile(EMAIL_REGEX);
//        Matcher matcher = pattern.matcher(email);
//        return matcher.matches();
//    }

    private static boolean emailIsValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
//        Matcher matcher = pattern.matcher(email);
        return pattern.matcher(email).matches();
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new User(this.username, this.password, this.email, this.creationTime);
    }
}
