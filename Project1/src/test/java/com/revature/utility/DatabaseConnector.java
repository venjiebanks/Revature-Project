package com.revature.utility;

import org.sqlite.SQLiteConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    public static Connection getConnection() throws SQLException {
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);
        String url = System.getenv("DATABASE_URL");
        if (url == null || url.isEmpty()) {
            url = "jdbc:sqlite:C:/Users/esvba/Desktop/Revature/planetarium.db";
        }
        return DriverManager.getConnection(url, config.toProperties());
    }
}
