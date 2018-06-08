package com.codeup.adlister.dao;

import com.codeup.adlister.Config;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import javax.management.relation.RoleUnresolved;
import java.sql.*;

public class MySQLUsersDao implements Users {
    private Connection connection;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    public User verifyUser(ResultSet rs) throws SQLException {
        // rs next has to be run in order to move the pointer to the next row
        if (!rs.next()) {
            return null;
        }
        return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")
        );
    }

    @Override
    public User findByUsername(String username) {
        try {
            String sql = "SELECT * FROM users WHERE username = ? LIMIT 1";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, username);
            return verifyUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Bad thing happen", e);
        }
    }

    @Override
    public Long insert(User user) {
        try {
            String sql = "INSERT INTO users (id, username, email, password) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, user.getId());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting the user into the database, take a look:", e);
        }
    }

    @Override
    public boolean validPass(String password) {
        return false;
    }
}
