package me.viharev.mockito.services;

import me.viharev.mockito.dao.DaoImpl;
import me.viharev.mockito.model.User;

public class UserServiceImpl implements UserService {

    private final DaoImpl daoImpl;

    public UserServiceImpl(DaoImpl daoImpl) {
        this.daoImpl = daoImpl;
    }

    public boolean checkUserExist(User user) {
        if (user != null) {
            return daoImpl.getUserByName(user.getName()) != null;
        }
        return false;
    }
}
