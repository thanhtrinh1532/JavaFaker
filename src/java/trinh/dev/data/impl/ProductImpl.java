package trinh.dev.data.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import trinh.dev.data.dao.ProductDao;
import trinh.dev.data.driver.MySQLDriver;
import trinh.dev.data.model.Product;

public class ProductImpl implements ProductDao {

    Connection con = MySQLDriver.getInstance().getConnection();

    @Override
    public boolean insert(Product product) {
        // TODO Auto-generated method stub
        String sql = "INSERT INTO PRODUCTS(ID, NAME, DESCRIPTION, THUMBNAIL, PRICE, QUANTITY, CATEGORY_ID) VALUES(NULL, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setString(3, product.getThumbnail());
            stmt.setDouble(4, product.getPrice());
            stmt.setInt(5, product.getQuantity());
            stmt.setInt(6, product.getCategoryId());
            stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Product product) {
        // TODO Auto-generated method stub
        String sql = "UPDATE PRODUCTS SET name = ?, description = ?, thumbnail = ?, price = ?, quantity = ?, category_id = ?, created_at = ? WHERE id = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setString(3, product.getThumbnail());
            stmt.setDouble(4, product.getPrice());
            stmt.setInt(5, product.getQuantity());
            stmt.setInt(6, product.getCategoryId());
            stmt.setTimestamp(7, product.getCreatedAt());
            stmt.setInt(8, product.getId());
            return stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        String sql = "DELETE FROM PRODUCTS WHERE ID =?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            return stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Product find(int id) {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM PRODUCTS WHERE ID = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                Double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int categoryId = rs.getInt("category_id");
                Timestamp created_at = rs.getTimestamp("created_at");
                return new Product(id, name, description, thumbnail, price, quantity, categoryId, created_at);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        // TODO Auto-generated method stub
        List<Product> prodList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTS";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                Double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int categoryId = rs.getInt("category_id");
                Timestamp created_at = rs.getTimestamp("created_at");
                prodList.add(new Product(id, name, description, thumbnail, price, quantity, categoryId, created_at));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return prodList;
    }

    @Override
    public List<Product> hot(int limit) {
        List<Product> proList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTS ORDER BY VIEW DESC LIMIT ?";

        // Try-with-resources to ensure resources are closed
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, limit);  // Set the limit parameter

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    String thumbnail = rs.getString("thumbnail");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    int categoryId = rs.getInt("category_id");
                    Timestamp createdAt = rs.getTimestamp("created_at");

                    // Add product to the list
                    proList.add(new Product(id, name, description, thumbnail, price, quantity, categoryId, createdAt));
                }
            }
        } catch (SQLException e) {
            // Log the error (can use a logging framework)
            System.err.println("SQL Error: " + e.getMessage());
        }

        return proList;  // Return the product list
    }

    @Override
    public List<Product> news(int limit) {
        List<Product> proList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTS ORDER BY VIEW DESC LIMIT ?";

        // Try-with-resources to ensure resources are closed
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, limit);  // Set the limit parameter

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    String thumbnail = rs.getString("thumbnail");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    int categoryId = rs.getInt("category_id");
                    Timestamp createdAt = rs.getTimestamp("created_at");

                    // Add product to the list
                    proList.add(new Product(id, name, description, thumbnail, price, quantity, categoryId, createdAt));
                }
            }
        } catch (SQLException e) {
            // Log the error (can use a logging framework)
            System.err.println("SQL Error: " + e.getMessage());
        }
        return proList;  // Return the product list
    }

    public List<Product> findByName(String name) {
        List<Product> proList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTS WHERE name = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
//                        String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                Double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int categoryId = rs.getInt("category_id");
                Timestamp created_at = rs.getTimestamp("created_at");
                proList.add(new Product(id, name, description, thumbnail, price, quantity, categoryId, created_at));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return proList;
    }

    @Override
    public List<Product> filter(int categoryId, String propertyName, String order) {
        List<Product> proList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTS WHERE category_id = ? ORDER BY ? ?";

        // Try-with-resources to ensure resources are closed
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, categoryId);
            stmt.setString(2, propertyName);
            stmt.setString(3, order);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    String thumbnail = rs.getString("thumbnail");
                    Double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    Timestamp created_at = rs.getTimestamp("created_at");

                    proList.add(new Product(id, name, description, thumbnail, price, quantity, categoryId, created_at));
                }
            }
        } catch (SQLException e) {
            // Log the error (can use a logging framework)
            System.err.println("SQL Error: " + e.getMessage());
        }
        return proList;  // Return the product list
    }

    @Override
    public List<Product> getProducts(int from, int amount) {
        List<Product> proList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTS LIMIT  ?, ?";

        // Try-with-resources to ensure resources are closed
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, from);
            stmt.setInt(2, amount);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                Double price = rs.getDouble("price");
                int categoryId = rs.getInt("category_id");
                int quantity = rs.getInt("quantity");
                Timestamp created_at = rs.getTimestamp("created_at");

                proList.add(new Product(id, name, description, thumbnail, price, quantity, categoryId, created_at));
            }
        } catch (SQLException e) {
            // Log the error (can use a logging framework)
            System.err.println("SQL Error: " + e.getMessage());
        }
        return proList;
    }
}
