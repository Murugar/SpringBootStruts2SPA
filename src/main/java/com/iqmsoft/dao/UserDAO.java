package com.iqmsoft.dao;

import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.iqmsoft.model.User;
 
public interface UserDAO {
    List<User> getUsers();
    void insertBatch();
}