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
        super("CREATE TABLE IF NOT EXISTS `shop`.`users` (\n"
                + "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `name` VARCHAR(45) NOT NULL,\n"
                + "  `email` VARCHAR(200) NOT NULL,\n"
                + "  `password` VARCHAR(45) NOT NULL,\n"
                + "  PRIMARY KEY (`id`))\n"
                + "ENGINE = InnoDB\n"
                + "DEFAULT CHARACTER SET = utf8;\n"
                + "\n"
                + "CREATE TABLE IF NOT EXISTS `shop`.`categories` (\n"
                + "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `name` VARCHAR(45) NOT NULL,\n"
                + "  `description` TEXT NULL DEFAULT NULL,\n"
                + "  `active` TINYINT(4) NOT NULL DEFAULT 1,\n"
                + "  PRIMARY KEY (`id`))\n"
                + "ENGINE = InnoDB\n"
                + "DEFAULT CHARACTER SET = utf8;\n"
                + "\n"
                + "CREATE TABLE IF NOT EXISTS `shop`.`products` (\n"
                + "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `name` VARCHAR(45) NOT NULL,\n"
                + "  `description` TEXT NULL DEFAULT NULL,\n"
                + "  `extrainfo` TEXT NULL DEFAULT NULL,\n"
                + "  `weight` FLOAT(11) NOT NULL,\n"
                + "  `highlighted` TINYINT(4) NOT NULL DEFAULT 0,\n"
                + "  `active` TINYINT(4) NOT NULL DEFAULT 1,\n"
                + "  `image` VARCHAR(200) NOT NULL,\n"
                + "  `categories_id` INT(11) NOT NULL,\n"
                + "  PRIMARY KEY (`id`),\n"
                + "  INDEX `fk_products_categories_idx` (`categories_id` ASC) VISIBLE,\n"
                + "  CONSTRAINT `fk_products_categories`\n"
                + "    FOREIGN KEY (`categories_id`)\n"
                + "    REFERENCES `shop`.`categories` (`id`)\n"
                + "    ON DELETE NO ACTION\n"
                + "    ON UPDATE NO ACTION)", "INSERT INTO users (id, name, email, password) VALUES(?, ?, ?, ?) ON DUPLICATE KEY UPDATE name=?, email=?, password=?",
                "DELETE FROM users WHERE id = ?", "SELECT * FROM users");
    }

    @Override
    public Object[] setupInsert(User value) {
        return new Object[]{value.getId(), value.getName(), value.getEmail(), value.getPassword()};
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
