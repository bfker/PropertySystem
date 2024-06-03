package com.propertysys.user.service.impl;

import com.propertysys.user.model.Role;
import com.propertysys.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.propertysys.user.dao.RoleDao;

import java.util.List;

@Service

public class RoleServiceImpl implements RoleService {
    @Autowired(required = false)
    private RoleDao roleDao;

    @Override
    public Role getRoleById(int roleID) {
        return roleDao.selectRoleById(roleID);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleDao.selectRoleByName(roleName);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDao.selectAllRoles();
    }

    @Override
    public void addRole(Role role) {
        roleDao.insertRole(role);
    }

    @Override
    public void updateRole(Role role) {
        roleDao.updateRole(role);
    }

    @Override
    public void deleteRole(int roleID) {
        roleDao.deleteRole(roleID);
    }
}
