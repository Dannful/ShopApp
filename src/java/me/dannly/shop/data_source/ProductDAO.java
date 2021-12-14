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
        super("INSERT INTO products (id, name, description, extrainfo, weight, highlighted, active, image, categories_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE name=?, description=?, extrainfo=?, weight=?, highlighted=?, active=?, image=?, categories_id=?", "DELETE FROM products WHERE id=?", "SELECT * FROM products");
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
