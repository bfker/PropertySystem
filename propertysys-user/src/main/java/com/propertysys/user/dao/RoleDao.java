package com.propertysys.user.dao;

import com.propertysys.user.model.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleDao {

    Role selectRoleById(int roleID);
    Role selectRoleByName(String roleName);
    List<Role> selectAllRoles();
    void insertRole(Role role);
    void updateRole(Role role);
    void deleteRole(int roleID);
}
