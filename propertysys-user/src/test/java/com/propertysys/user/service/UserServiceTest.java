package com.propertysys.user.service;

import com.propertysys.user.dao.UserDao;
import com.propertysys.user.model.User;
import com.propertysys.user.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegisterService_UserAlreadyExists() {
        User existingUser = new User();
        existingUser.setEmail("test@example.com");

        when(userDao.selectUserByEmail(anyString())).thenReturn(existingUser);

        User newUser = new User();
        newUser.setEmail("test@example.com");
        newUser.setPassword("password");

        User result = userService.registerService(newUser,1);
        assertNull(result);
        verify(userDao, never()).insertUser(any(User.class));
    }

    @Test
    public void testRegisterService_UserDoesNotExist() {
        when(userDao.selectUserByEmail(anyString())).thenReturn(null);

        User newUser = new User();
        newUser.setEmail("test@example.com");
        newUser.setPassword("password");

        userService.registerService(newUser,1);
        verify(userDao).insertUser(newUser);
        verify(userDao).insertUserRole(newUser.getUserID(), 1);
    }

    @Test
    public void testLoginService_Success() {
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");

        when(userDao.login(anyString(), anyString())).thenReturn(user);

        User result = userService.loginService("test@example.com", "password");
        assertNotNull(result);
        assertEquals("test@example.com", result.getEmail());
    }

    @Test
    public void testLoginService_Failure() {
        when(userDao.login(anyString(), anyString())).thenReturn(null);

        User result = userService.loginService("wrong@example.com", "password");
        assertNull(result);
    }

    @Test
    public void testGetAllUsers() {
        List<User> users = List.of(new User(), new User());
        when(userDao.selectAllUsers()).thenReturn(users);

        List<User> result = userService.getAllUsers();
        assertEquals(2, result.size());
    }

    @Test
    public void testGetUserById() {
        User user = new User();
        user.setUserID(1);

        when(userDao.selectUserById(anyInt())).thenReturn(user);

        User result = userService.getUserById(1);
        assertNotNull(result);
        assertEquals(1, result.getUserID());
    }

    @Test
    public void testGetUserByEmail() {
        User user = new User();
        user.setEmail("test@example.com");

        when(userDao.selectUserByEmail(anyString())).thenReturn(user);

        User result = userService.getUserByEmail("test@example.com");
        assertNotNull(result);
        assertEquals("test@example.com", result.getEmail());
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setUserID(1);
        user.setEmail("test@example.com");

        userService.updateUser(user);
        verify(userDao).updateUser(user);
    }

    @Test
    public void testDeleteUser() {
        int userID = 1;

        userService.deleteUser(userID);
        verify(userDao).deleteUserRolesByUserId(userID);
        verify(userDao).deleteUser(userID);
    }
}
