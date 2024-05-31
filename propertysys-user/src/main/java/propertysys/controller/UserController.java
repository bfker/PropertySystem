package propertysys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import propertysys.model.User;
import propertysys.service.UserService;
import propertysys.utils.JWTUtils;
import propertysys.utils.Result;
import propertysys.utils.ResultCodeEnum;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user") // /user/
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/register") //  /user/register/
    public Result<User> register(@RequestBody User user) // json 传参
    {
        if(userService.registerService(user) != null) {
            return Result.success(user);
        }
        else {
            return  Result.failure(ResultCodeEnum.USER_IS_EXIST);
        }
    }

    //  返回token
    @RequestMapping("/login") //  /user/login/
    public Result login(@RequestBody User user) // json 传参
    {
       User userFromJDBC = userService.loginService(user.getEmail(),user.getPassword());
       if(userFromJDBC == null) {
           return Result.failure(ResultCodeEnum.UNAUTHORIZED, "Incorrect email or password");
       }
       else {
           String token = JWTUtils.getToken(userFromJDBC.getUserID(), userFromJDBC.getEmail());
           Map<String, String> userMap = new HashMap<>();
           userMap.put("userID", userFromJDBC.getUserID());
           userMap.put("email", userFromJDBC.getEmail());
           userMap.put("token", token);
           return Result.success(userMap);

       }
    }
}

