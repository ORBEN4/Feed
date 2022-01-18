package com.example.feedserver.memorymanagers.datastructure.sql.query;

import com.example.feedserver.helpers.FeedException;
import com.example.feedserver.memorymanagers.datastructure.sql.QueryType;
import com.example.feedserver.memorymanagers.datastructure.sql.Statementable;
import com.example.feedserver.memorymanagers.datatype.Property;

import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class Query implements Statementable {
    final String schemaName;
    final String tableName;
    final QueryType type;
    final List<Property> properties;

    public Query(String schemaName, String tableName, QueryType type, ArrayList<Property> parameters) {
        this.schemaName = schemaName;
        this.tableName = tableName;
        this.type = type;
        this.properties = parameters;
    }

    @Override
    public PreparedStatement build(Connection connection) throws FeedException {
        try {
            PreparedStatement statement = connection.prepareStatement(buildQueryStructure());
            for (int index = 0; index < properties.size(); index++) {
                statement.setObject(index + 1, this.properties.get(index).getValue(), this.properties.get(index).getType());
            }
            return statement;
        } catch (SQLException throwables) {
            // TODO: 09/01/2022 add custom exception
            throw new FeedException(throwables);
        }
    }

    String buildQueryStructure() {
        return MessageFormat.format(this.type.getQuery(), this.schemaName, this.tableName, "(?" +
                ",?".repeat(Math.max(0, this.getInputCount() - 1)) +
                ")");
    }

    @Override
    public Integer getInputCount() {
        return this.properties.size();
    }


    public String getSchemaName() {
        return schemaName;
    }

    public String getTableName() {
        return tableName;
    }

    public QueryType getType() {
        return type;
    }

    public List<Property> getProperties() {
        return properties;
    }
}
