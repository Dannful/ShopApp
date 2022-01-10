/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.dannly.shop.data_source;

import java.sql.ResultSet;
import java.sql.SQLException;
import me.dannly.shop.domain.repository.DatabaseRepository;
import me.dannly.shop.domain.model.Product;

/**
 *
 * @author vinix
 */
public class ProductDAO extends DatabaseRepository<Product> {

    public ProductDAO() {
        super("CREATE TABLE IF NOT EXISTS `shop`.`products` (\n"
                + "  `id` INT NOT NULL AUTO_INCREMENT,\n"
                + "  `name` VARCHAR(45) NOT NULL,\n"
                + "  `description` TEXT NULL,\n"
                + "  `extrainfo` TEXT NULL,\n"
                + "  `weight` FLOAT NOT NULL,\n"
                + "  `highlighted` TINYINT NOT NULL DEFAULT 0,\n"
                + "  `active` TINYINT NOT NULL DEFAULT 1,\n"
                + "  `image` VARCHAR(200) NOT NULL,\n"
                + "  `categories_id` INT NOT NULL,\n"
                + "  PRIMARY KEY (`id`),\n"
                + "  INDEX `fk_products_categories_idx` (`categories_id` ASC) VISIBLE,\n"
                + "  CONSTRAINT `fk_products_categories`\n"
                + "    FOREIGN KEY (`categories_id`)\n"
                + "    REFERENCES `shop`.`categories` (`id`)\n"
                + "    ON DELETE NO ACTION\n"
                + "    ON UPDATE NO ACTION)\n"
                + "ENGINE = InnoDB", "INSERT INTO products (id, name, description, extrainfo, weight, highlighted, active, image, categories_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE name=?, description=?, extrainfo=?, weight=?, highlighted=?, active=?, image=?, categories_id=?", "DELETE FROM products WHERE id=?", "SELECT * FROM products");
    }

    @Override
    public Object[] setupInsert(Product value) {
        return new Object[]{value.getId(), value.getName(), value.getDescription(), value.getExtraInfo(), value.getWeight(), value.getHighlighted(), value.getActive(), value.getImage(), value.getCategoriesId()};
    }

    @Override
    public Object setupDelete(Product value) {
        return value.getId();
    }

    @Override
    public Product setupRead(ResultSet resultSet) {
        try {
            return new Product(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("description"), resultSet.getString("extrainfo"), resultSet.getFloat("weight"), resultSet.getBoolean("highlighted"), resultSet.getBoolean("active"), resultSet.getString("image"), resultSet.getInt("categories_id"));
        } catch (SQLException ex) {
        }
        return null;
    }
}
