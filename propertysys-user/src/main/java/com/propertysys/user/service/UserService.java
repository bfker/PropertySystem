package com.propertysys.user.service;
import com.propertysys.user.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    List<String> selectRolesByUserId(int userID);

    //注册
    User registerService(User user,int roleID);
    User loginService(String email, String password);

    User getUserInfo(int userID);

    User getUserById(int userID);
    User getUserByEmail(String email);
    void updateUser(User user);
    boolean deleteUser(int userID);


}
