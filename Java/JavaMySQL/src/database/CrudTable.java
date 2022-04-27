package database;

import models.DailyDevotion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface CrudTable {
    void createDatabase(Connection connection) throws SQLException;

    void useDatabase(Connection connection) throws SQLException;

    void createTable(Connection connection) throws SQLException;

    void insertData(DailyDevotion dailyDevotion) throws SQLException;

    ResultSet getData(Connection connection) throws SQLException;

    void updateData(DailyDevotion dailyDevotion) throws SQLException;

    void deleteData(int id) throws SQLException;
}

