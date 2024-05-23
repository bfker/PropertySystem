package propertysys.dao;

import org.apache.ibatis.annotations.Mapper;
import propertysys.model.User;
@Mapper
public interface UserDao {
    //注册
    int register(User user);

    //根据用户名搜索
    User findByEmail(String email);
    //登录
    User login(String email,String password);
}
