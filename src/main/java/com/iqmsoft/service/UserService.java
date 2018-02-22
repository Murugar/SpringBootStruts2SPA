package com.iqmsoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.iqmsoft.dao.UserDAO;
import com.iqmsoft.model.User;

import java.util.List;

@Service("userService")
public class UserService implements ServiceFacade {
     
    @Autowired
    private UserDAO userDAO;

    @Override
    public void putUsers() {
        userDAO.insertBatch();
    }

    @Override
    public List<User> retrieveUsers() {
        return userDAO.getUsers();
    }

}