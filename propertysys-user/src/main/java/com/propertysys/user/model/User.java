package com.propertysys.user.model;

import lombok.Data;

@Data
public class User {
    private int userID;
    private String name;
    private String email;
    private String password;
}
