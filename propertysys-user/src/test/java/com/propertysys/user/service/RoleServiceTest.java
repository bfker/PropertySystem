package com.propertysys.user.service;

import com.propertysys.user.dao.RoleDao;
import com.propertysys.user.model.Role;
import com.propertysys.user.service.impl.RoleServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class RoleServiceTest {

    @Mock
    private RoleDao roleDao;

    @InjectMocks
    private RoleServiceImpl roleService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetRoleById() {
        Role role = new Role();
        role.setRoleID(1);
        role.setRoleName("seller");

        when(roleDao.selectRoleById(anyInt())).thenReturn(role);

        Role result = roleService.getRoleById(1);
        assertNotNull(result);
        assertEquals(1, result.getRoleID());
        assertEquals("seller", result.getRoleName());
    }

    @Test
    public void testGetRoleByName() {
        Role role = new Role();
        role.setRoleName("seller");

        when(roleDao.selectRoleByName(anyString())).thenReturn(role);

        Role result = roleService.getRoleByName("seller");
        assertNotNull(result);
        assertEquals("seller", result.getRoleName());
    }

    @Test
    public void testGetAllRoles() {
        List<Role> roles = List.of(new Role(), new Role());
        when(roleDao.selectAllRoles()).thenReturn(roles);

        List<Role> result = roleService.getAllRoles();
        assertEquals(2, result.size());
    }

    @Test
    public void testAddRole() {
        Role role = new Role();
        role.setRoleName("buyer");

        roleService.addRole(role);
        verify(roleDao).insertRole(role);
    }

    @Test
    public void testUpdateRole() {
        Role role = new Role();
        role.setRoleID(1);
        role.setRoleName("admin");

        roleService.updateRole(role);
        verify(roleDao).updateRole(role);
    }

    @Test
    public void testDeleteRole() {
        int roleID = 1;

        roleService.deleteRole(roleID);
        verify(roleDao).deleteRole(roleID);
    }
}
