package me.viharev.mockito;

import me.viharev.mockito.dao.DaoImpl;
import me.viharev.mockito.model.User;
import me.viharev.mockito.services.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {

    private final DaoImpl daoImpl = Mockito.mock(DaoImpl.class);
    private final UserServiceImpl userService;

    public UserServiceImplTest() {
        userService = new UserServiceImpl(daoImpl);
    }

    @Test
    void checkExistUserMustReturnTrue() {
        User correctUser = new User("Tom", 33);
        when(daoImpl.getUserByName("Tom")).thenReturn(correctUser);
        boolean checkUser = userService.checkUserExist(correctUser);
        assertTrue(checkUser);
    }

    @Test
    void checkNonExistUserMustReturnFalse() {
        User wrongUser = null;
        when(daoImpl.getUserByName("Wrong Name")).thenReturn(wrongUser);
        boolean checkUser = userService.checkUserExist(wrongUser);
        assertFalse(checkUser);
    }
}
