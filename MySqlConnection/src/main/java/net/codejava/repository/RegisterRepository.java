package net.codejava.repository;

//import java.util.*;
//import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;

import net.codejava.model.RegModel;

import java.util.Collections;


@Repository
public class RegisterRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final String addUser_sql = "INSERT INTO register (username, password, confirmPassword, email, mobileNumber,registrationNumber, address)"
            + "VALUES (?, ?, ?, ?, ?, ?, ?)";

    // private final String getUserSQL = "SELECT username, password FROM register where username = ?";

    @Transactional
    public int addUser(RegModel userToAdd) {
        int ret = 0;
        if (userToAdd != null) {
            ret = jdbcTemplate.update(addUser_sql, userToAdd.getUsername(), userToAdd.getPassword(),
                    userToAdd.getConfirmPassword(), userToAdd.getEmail(), userToAdd.getMobileNumber(),
                    userToAdd.getRegistrationNumber(), userToAdd.getAddress());
            System.out.println(ret);

        } else {
            System.out.println("User to add is invalid. Null Object.");
        }
        return ret;
    }

    public String getUser(String username){
        String sql = "SELECT password FROM register WHERE username = ?";
        String result = jdbcTemplate.queryForObject(sql, new Object[] { username}, String.class);
        return result;
        
    }
}
