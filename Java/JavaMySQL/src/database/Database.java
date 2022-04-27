package database;

import models.DailyDevotion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Database implements CrudTable {
    // Make connection to database
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/dailyDevotion", "root", "root");
    }

    // Create database if not exists
    public void createDatabase(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("CREATE DATABASE IF NOT EXISTS dailyDevotion");
    }

    @Override
    public void useDatabase(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("USE dailyDevotion");
    }

    // Create database if not exists
    public void createTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS dailyDevotion " + "(id INT NOT NULL AUTO_INCREMENT, title VARCHAR(255)," + "content VARCHAR(512),PRIMARY KEY (id))");
    }

    // Get data from database
    public ResultSet getData(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("Select * from dailyDevotion");
        return rs;
    }

    // Insert data to database
    public void insertData(DailyDevotion dailyDevotion) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO dailyDevotion (title, content) VALUES ('" + dailyDevotion.getTitle() + "', '" + dailyDevotion.getContent() + "')");
    }


    // Update data to database
    public void updateData(DailyDevotion dailyDevotion) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("Update dailyDevotion set title = '" + dailyDevotion.getTitle() + "', content = '" + dailyDevotion.getContent() + "',  where id = '" + dailyDevotion.getId() + "'");
    }

    // Delete data to database
    public void deleteData(int id) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM dailyDevotion WHERE id = '" + id + "'");
    }
}