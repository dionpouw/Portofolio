package database;

import models.DailyDevotion;

import java.sql.*;

public class Database implements CrudTable {
    // Make connection to database

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/dailyDevotion", "root", "root");
    }
    @Override
    public void createTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS dailyDevotion " + "(id INT NOT NULL AUTO_INCREMENT, title VARCHAR(255)," + "content VARCHAR(512),PRIMARY KEY (id))");
    }

    // Get data from database
    @Override
    public ResultSet getData(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery("Select * from dailyDevotion");
    }

    // Insert data to database
    @Override
    public void insertData(DailyDevotion dailyDevotion) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO dailyDevotion (title, content) VALUES ('" + dailyDevotion.getTitle() + "', '" + dailyDevotion.getContent() + "')");
    }

    // Update data to database
    @Override
    public void updateData(DailyDevotion dailyDevotion, int id) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("Update dailyDevotion set title = '" + dailyDevotion.getTitle() + "', content = '" + dailyDevotion.getContent() + "' where id = '" + id + "'");
    }

    // Delete data to database
    @Override
    public void deleteData(int id) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM dailyDevotion WHERE id = '" + id + "'");
    }
}