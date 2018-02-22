package com.iqmsoft.service;


import java.util.List;

import com.iqmsoft.model.User;

public interface ServiceFacade {
    void putUsers();
    List<User> retrieveUsers();
}