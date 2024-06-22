package com.propertysys.user.service.impl;

import com.propertysys.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.propertysys.user.dao.UserDao;
import com.propertysys.user.service.UserService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    UserDao userDao;
    @Override
    public User registerService(User user, int roleID) {
        User userTmp = userDao.selectUserByEmail(user.getEmail());
        if(userTmp != null) {
            return null;
        }
        else {
            userDao.insertUser(user);
            userDao.insertUserRole(user.getUserID(), roleID);
            return user;
        }
    }

    @Override
    public User loginService(String email, String password) {
        return userDao.login(email, password);
    }

    @Override
    public User getUserInfo(int userID) {
        return userDao.getUserInfo(userID);
    }

    public List<User> getAllUsers() {
        return userDao.selectAllUsers();
    }

    @Override
    public List<String> selectRolesByUserId(int userID) {
        return userDao.selectRolesByUserId(userID);
    }

    @Override
    public User getUserById(int userID) {
        return userDao.selectUserById(userID);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.selectUserByEmail(email);
    }
    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    @Transactional
    public boolean deleteUser(int userID) {
        userDao.deleteUserRolesByUserId(userID);
        userDao.deleteUser(userID);
        return true;
    }


}
