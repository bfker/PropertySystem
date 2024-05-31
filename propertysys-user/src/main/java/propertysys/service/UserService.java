package propertysys.service;
import propertysys.model.User;
public interface UserService {
    //注册
    User registerService(User user);
    User loginService(String email, String password);


}
