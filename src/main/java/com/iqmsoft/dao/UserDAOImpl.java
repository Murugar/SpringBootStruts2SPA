package com.iqmsoft.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.iqmsoft.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
 
    @Autowired
    private JdbcTemplate jdbcTemplate;
 
    public List<User> getUsers() {
        return jdbcTemplate.query("SELECT id, first_name, last_name, age, gender FROM users",
                (rs, rowNum) -> new User(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("age"), rs.getString("gender")));
    }
 
    public void insertBatch() {
        jdbcTemplate.execute("DROP TABLE users IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE users(id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255), age VARCHAR(3), gender VARCHAR(1))");
        jdbcTemplate.batchUpdate("INSERT INTO users(first_name, last_name, age, gender) VALUES (?,?,?,?)", userData());
    }
 
    private List<Object[]> userData() {
        List<Object[]> users = new ArrayList<>();
        users.add("Test1 Test1 26 M".split(" "));
        users.add("Test2 Test2 27 F".split(" "));
        users.add("Test3 Test3 34 F".split(" "));
        users.add("Test4 Test4 21 M".split(" "));
        users.add("Test5 Test5 18 M".split(" "));
        users.add("Test6 Test6 19 F".split(" "));
        users.add("Test7 Test7 15 F".split(" "));
        users.add("Test8 Test8 24 F".split(" "));
        users.add("Test9 Test9 40 M".split(" "));
        users.add("Test10 Test10 42 F".split(" "));
        return users;
    }
     
}