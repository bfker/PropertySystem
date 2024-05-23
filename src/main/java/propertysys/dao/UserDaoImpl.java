package propertysys.dao;

import propertysys.model.User;

public class UserDaoImpl implements UserDao {
    @Override
    public int register(User user) {
        return 0;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User login(String email, String password) {
        return null;
    }
}
