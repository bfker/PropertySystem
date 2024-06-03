package com.propertysys.user.service;
import com.propertysys.user.model.Role;

import java.util.List;

public interface RoleService {
    Role getRoleById(int roleID);
    Role getRoleByName(String roleName);
    List<Role> getAllRoles();
    void addRole(Role role);
    void updateRole(Role role);
    void deleteRole(int roleID);
}
