package propertysys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import propertysys.dao.UserDao;
import propertysys.model.User;
import propertysys.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    UserDao userDao;
    @Override
    public User registerService(User user) {
        User userTmp = userDao.selectUserByEmail(user.getEmail());
        if(userTmp != null) {
            return null;
        }
        else {
            userDao.insertUser(user);
            //TODO: user_role注册的逻辑
            String roleID = "1"; // Assuming roleID for 'ROLE_USER' is 1
            userDao.insertUserRole(user.getUserID(), roleID);
            return user;
        }
    }

    @Override
    public User loginService(String email, String password) {
        return userDao.login(email, password);
    }
}
