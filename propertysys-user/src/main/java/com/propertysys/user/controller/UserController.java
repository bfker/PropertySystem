package com.propertysys.user.controller;

import com.propertysys.user.model.User;
import com.propertysys.user.model.UserRegisterRequest;
import com.propertysys.user.service.UserService;
import com.propertysys.user.utils.JWTUtils;
import com.propertysys.user.utils.Result;
import com.propertysys.user.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user") // /user/
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/register") //  /user/register/
    public Result<User> register(@RequestBody UserRegisterRequest request) // json 传参
    {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        if(userService.registerService(user,request.getRoleID()) != null) {
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
           String token = JWTUtils.getToken(String.valueOf(userFromJDBC.getUserID()), userFromJDBC.getEmail());
           List<String> roles = userService.selectRolesByUserId(userFromJDBC.getUserID());
           Map<String, Object> userMap = new HashMap<>();
           userMap.put("userID", String.valueOf(userFromJDBC.getUserID()));
           userMap.put("email", userFromJDBC.getEmail());
           userMap.put("roles", roles);
           userMap.put("token", token);
           return Result.success(userMap);

       }
    }

    @GetMapping("/all")
    public Result<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return Result.success(users);
    }

    @GetMapping("/{userID}")
    public Result<User> getUserById(@PathVariable("userID") int userID) {
        User user = userService.getUserById(userID);
        if (user != null) {
            return Result.success(user);
        } else {
            return Result.failure(ResultCodeEnum.NOT_FOUND);
        }
    }

    @GetMapping("/userInfo/{userID}")
    public Result<User> getUserPersonalInfo(@PathVariable("userID") int userID) {
        User user = userService.getUserInfo(userID);
        if (user != null) {
            return Result.success(user);
        } else {
            return Result.failure(ResultCodeEnum.NOT_FOUND);
        }
    }


    @PostMapping("/update")
    public Result<User> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return Result.success(user);
    }

    @DeleteMapping("/delete/{userID}")
    public Result<Void> deleteUser(@PathVariable("userID") int userID) {
        boolean isDeleted = userService.deleteUser(userID);
        if (isDeleted) {
            return Result.success();
        } else {
            return Result.failure(ResultCodeEnum.NOT_FOUND);
        }
    }


    @PostMapping("/logout/{userID}")
    public Result<Void> logout(@PathVariable("userID") int userID) {
        return Result.success();
    }

}

