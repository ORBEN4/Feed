package com.example.feedserver.memorymanagers;

import com.example.feedserver.helpers.ConfigurationManager;
import com.example.feedserver.helpers.FeedException;
import com.example.feedserver.helpers.Property;
import com.example.feedserver.memorymanagers.constant.MySql;

import java.sql.*;
import java.util.Map;

public class MySqlMemoryManager {
    private Connection connection;

    public MySqlMemoryManager() {
        try {
            this.connection = connect();
        } catch (SQLException throwable) {
            System.out.println("SQLException: " + throwable.getMessage());
            System.out.println("SQLState: " + throwable.getSQLState());
            System.out.println("VendorError: " + throwable.getErrorCode());
        } catch (ClassNotFoundException | FeedException throwable) {
            throwable.printStackTrace();
        }
    }

    private Connection connect() throws SQLException, ClassNotFoundException, FeedException {
        try {
            Class.forName(ConfigurationManager.getInstance().getProperty(MySql.DRIVER));
            return DriverManager.getConnection(
                    ConfigurationManager.getInstance().getProperty(MySql.CONNECTION_STRING),
                    ConfigurationManager.getInstance().getProperty(MySql.USERNAME),
                    ConfigurationManager.getInstance().getProperty(MySql.PASSWORD));
        } catch (FeedException e) {
            throw new FeedException(e);
        }
    }

    public Object testReadQuery(String rawQuery) {
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

    public Object procedure(Map<Integer, Property> properties, String query) {
        try {
            CallableStatement statement = this.assignValuesToProcedureStatement(properties, connection.prepareCall(query));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "temp";
    }

    public Object procedure(Map<Integer, Property> properties) {
        return this.procedure(properties, "CALL users.register_internal_user(?,?,?,?)");
    }

    private CallableStatement assignValuesToProcedureStatement(Map<Integer, Property> properties, CallableStatement statement) {
        try {
            for (Integer key :
                    properties.keySet()) {
//                Property property = properties.get(key);
                switch (properties.get(key).getType()) {
                    case ("String") -> {
                        statement.setString(key, (String) properties.get(key).getValue());
                    }
                    case ("Output") -> {
                        switch (properties.get(key).getValue().getClass().getSimpleName()) {
                            case ("String") -> {
                                statement.registerOutParameter(key, Types.VARCHAR);
                            }
                            case ("Integer") -> {
                                statement.registerOutParameter(key, Types.INTEGER);
                            }
                            case ("Date") -> {
                                statement.registerOutParameter(key, Types.DATE);
                            }
                            case ("Timestamp") -> {
                                statement.registerOutParameter(key, Types.TIMESTAMP);
                            }
                            case ("Time") -> {
                                statement.registerOutParameter(key, Types.TIME);
                            }
                            default -> {
                                statement.registerOutParameter(key, Types.JAVA_OBJECT);
                            }
                        }
                    }

                    case ("Integer") -> {
                        statement.setInt(key, (Integer) properties.get(key).getValue());
                    }
                    case ("Date"), ("Timestamp"), ("Time"), ("DateTime") -> {
                        statement.setDate(key, (Date) properties.get(key).getValue());
                    }
                    default -> {
                        statement.setObject(key, properties.get(key).getValue());
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return statement;
    }
}

