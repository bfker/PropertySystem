package propertysys.model;

import lombok.Data;

@Data
public class User {
    private String userID;
    private String name;
    private String email;
    private String password;
}
