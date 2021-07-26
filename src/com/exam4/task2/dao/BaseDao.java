package com.exam4.task2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
    private static final String url = "jdbc:postgresql://localhost:5432/";
    private static final String user = "postgres";
    private static final String password = "0771541217b";

    public Connection connect() throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
}
