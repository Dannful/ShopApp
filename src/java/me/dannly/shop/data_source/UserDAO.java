/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.dannly.shop.data_source;

import java.sql.ResultSet;
import java.sql.SQLException;
import me.dannly.shop.domain.model.User;
import me.dannly.shop.domain.repository.DatabaseRepository;

/**
 *
 * @author vinix
 */
public class UserDAO extends DatabaseRepository<User> {

    public UserDAO() {
        super("INSERT INTO users (id, name, email, password) VALUES(?, ?, ?, ?) ON DUPLICATE KEY UPDATE name=?, email=?, password=?",
                "DELETE FROM users WHERE id = ?", "SELECT * FROM users");
    }

    @Override
    public Object[] setupInsert(User value) {
        return new Object[] { value.getId(), value.getName(), value.getEmail(), value.getPassword() };
    }

    @Override
    public Object setupDelete(User value) {
        return value.getId();
    }

    @Override
    public User setupRead(ResultSet resultSet) {
        try {
            return new User(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("email"), resultSet.getString("password"));
        } catch (SQLException ex) {
        }
        return null;
    }
}
