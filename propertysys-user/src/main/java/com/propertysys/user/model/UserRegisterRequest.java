package com.propertysys.user.model;

import lombok.Data;

@Data
public class UserRegisterRequest {
    private String name;
    private String email;
    private String password;
    private int roleID;

    public UserRegisterRequest() {}
}
