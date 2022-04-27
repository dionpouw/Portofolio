package database;

import models.DailyDevotion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface CrudTable {
    void createTable(Connection connection) throws SQLException;

    void insertData(DailyDevotion dailyDevotion) throws SQLException;

    ResultSet getData(Connection connection) throws SQLException;

    void updateData(DailyDevotion dailyDevotion, int id) throws SQLException;

    void deleteData(int id) throws SQLException;
}

