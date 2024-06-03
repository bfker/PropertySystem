package com.propertysys.user.controller;

import com.propertysys.user.model.Role;
import com.propertysys.user.service.RoleService;
import com.propertysys.user.utils.Result;
import com.propertysys.user.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/add")
    public Result<Role> addRole(@RequestBody Role role) {
        try {
            roleService.addRole(role);
            return Result.success(role);
        } catch (Exception e) {
            return Result.failure(ResultCodeEnum.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping("/all")
    public Result<List<Role>> getAllRoles() {
        try {
            List<Role> roles = roleService.getAllRoles();
            return Result.success(roles);
        } catch (Exception e) {
            return Result.failure(ResultCodeEnum.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping("/{roleID}")
    public Result<Role> getRoleById(@PathVariable int roleID) {
        try {
            Role role = roleService.getRoleById(roleID);
            if (role != null) {
                return Result.success(role);
            } else {
                return Result.failure(ResultCodeEnum.NOT_FOUND, "Role not found");
            }
        } catch (Exception e) {
            return Result.failure(ResultCodeEnum.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PutMapping("/update")
    public Result<Role> updateRole(@RequestBody Role role) {
        try {
            roleService.updateRole(role);
            return Result.success(role);
        } catch (Exception e) {
            return Result.failure(ResultCodeEnum.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @DeleteMapping("/delete/{roleID}")
    public Result<Void> deleteRole(@PathVariable int roleID) {
        try {
            roleService.deleteRole(roleID);
            return Result.success();
        } catch (Exception e) {
            return Result.failure(ResultCodeEnum.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
