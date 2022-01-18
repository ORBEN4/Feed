package com.example.feedserver.memorymanagers.datastructure.sql;

import com.example.feedserver.helpers.FeedException;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

public class Procedure implements Statementable {
    private final String schemaName;
    private final String procedureName;
    private final Map<String, Integer> parameters;

    public Procedure(String schemaName, String procedureName, LinkedHashMap<String, Integer> parameters) {
        this.schemaName = schemaName;
        this.procedureName = procedureName;
        this.parameters = parameters;
    }

    @Override
    public Statement build(Connection connection) throws FeedException {
        try {
            CallableStatement statement = connection.prepareCall(buildQueryStructure());
//            for (int index = 1; index <= getInputCount(); index++) {
//
//            }


            return statement;
        } catch (SQLException throwables) {
            // TODO: 09/01/2022 add custom exception
            throw new FeedException(throwables);
        }
    }

    @Override
    public Integer getInputCount() {
        return this.parameters.size();
    }

    private String buildQueryStructure() {
        return "CALL " + this.schemaName + " " + this.procedureName + "(?" +
                ",?".repeat(Math.max(0, this.getInputCount() - 1)) +
                ")";
    }
}
