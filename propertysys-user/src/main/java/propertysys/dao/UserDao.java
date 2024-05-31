package propertysys.dao;

import org.apache.ibatis.annotations.*;
import propertysys.model.User;

import java.util.List;

@Mapper
public interface UserDao {
    //注册
//    int register(User user);
//
//    //根据用户名搜索
//    User findByEmail(String email);
//    //登录
    User login(String email,String password);


    User selectUserById(String userID);

    User selectUserByEmail(String email);

    List<String> selectRolesByUserId(String userID);

    void insertUser(User user);

    void insertUserRole(String userID, String roleID);

    void updateUser(User user);

    void deleteUser(String userID);





}
