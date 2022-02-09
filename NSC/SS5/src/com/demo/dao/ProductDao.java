package com.demo.dao;

import com.demo.model.Product;
import com.demo.utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    Connection connection = ConnectionUtils.getConnection();

    public int insertProduct() {
        String sql = "INSERT INTO product(name,price,quantity,category_id) VALUES(?,?,?,?)";
        int success = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "Iphone 12");
            ps.setInt(2, 1000);
            ps.setInt(3, 5);
            ps.setInt(4, 1);
            success = ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return success;
    }

    public List<Product> getAllProduct(String pName) {
        List<Product> list = new ArrayList<>();

        String sql = "select * from product where name = "+pName;
//        String sql = "select * from product where name = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setString(1, pName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                int categoryID = rs.getInt("category_id");
                Product p = new Product(name, price, quantity, categoryID);
                list.add(p);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

}
