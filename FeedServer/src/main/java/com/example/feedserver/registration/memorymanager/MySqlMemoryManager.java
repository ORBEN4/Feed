package com.example.feedserver.registration.memorymanager;

import java.sql.*;

public class MySqlMemoryManager {
    private Connection connection;

    public MySqlMemoryManager() {
        try {
            this.connection = connect();
        } catch (SQLException throwable) {
            System.out.println("SQLException: " + throwable.getMessage());
            System.out.println("SQLState: " + throwable.getSQLState());
            System.out.println("VendorError: " + throwable.getErrorCode());
        } catch (ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    private Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306", "root", "");
    }

    public Object test(String rawQuery) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(rawQuery);
            StringBuilder ret = new StringBuilder();
            while (rs.next())
                ret.append(rs.getString(2)).append(" is ").append(rs.getInt(1)).append("\n")/* + "  " + rs.getString(3)*/;
            connection.close();
//            return this.connection.prepareStatement(rawQuery).executeQuery();
            return ret.toString();
        } catch (SQLException throwables) {
            return throwables.getMessage();
        }
    }
}
