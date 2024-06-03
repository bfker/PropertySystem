package com.propertysys.user.dao;

import com.propertysys.user.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    //注册
//    int register(User user);
//
//    //根据用户名搜索
//    User findByEmail(String email);
//    //登录
    User login(String email, String password);


    User selectUserById(int userID);

    User selectUserByEmail(String email);

    List<String> selectRolesByUserId(int userID);

    List<User> selectAllUsers();

    void insertUser(User user);

    void insertUserRole(int userID, int roleID);

    void updateUser(User user);

    void deleteUserRolesByUserId(int userID);

    void deleteUser(int userID);





}
