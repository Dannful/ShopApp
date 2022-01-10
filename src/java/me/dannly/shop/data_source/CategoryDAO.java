/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.dannly.shop.data_source;

import me.dannly.shop.domain.repository.DatabaseRepository;
import java.sql.ResultSet;
import java.sql.SQLException;
import me.dannly.shop.domain.model.Category;

/**
 *
 * @author vinix
 */
public class CategoryDAO extends DatabaseRepository<Category> {

    public CategoryDAO() {
        super("CREATE TABLE IF NOT EXISTS `shop`.`categories` (\n"
                + "  `id` INT NOT NULL AUTO_INCREMENT,\n"
                + "  `name` VARCHAR(45) NOT NULL,\n"
                + "  `description` TEXT NULL,\n"
                + "  `active` TINYINT NOT NULL DEFAULT 1,\n"
                + "  PRIMARY KEY (`id`))\n"
                + "ENGINE = InnoDB", "INSERT INTO categories (id, name, description, active) VALUES(?, ?, ?, ?) ON DUPLICATE KEY UPDATE name=?, description=?, active=?",
                "DELETE FROM categories WHERE id = ?", "SELECT * FROM categories");
    }

    @Override
    public Object[] setupInsert(Category value) {
        return new Object[]{value.getId(), value.getName(), value.getDescription(), value.getActive()};
    }

    @Override
    public Object setupDelete(Category value) {
        return value.getId();
    }

    @Override
    public Category setupRead(ResultSet resultSet) {
        try {
            return new Category(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("description"), resultSet.getBoolean("active"));
        } catch (SQLException ex) {
        }
        return null;
    }
}
