package com.example.feedserver.memorymanagers.datastructure.sql.query;

import com.example.feedserver.memorymanagers.datastructure.sql.QueryType;
import com.example.feedserver.memorymanagers.datatype.Property;

import java.text.MessageFormat;
import java.util.ArrayList;

public class SelectQuery extends Query {
    public SelectQuery(String schemaName, String tableName, QueryType type, ArrayList<Property> parameters) {
        super(schemaName, tableName, type, parameters);
    }

    @Override
    String buildQueryStructure() {
        return MessageFormat.format(this.type.getQuery(), this.schemaName, this.tableName, "(?" +
                ",?".repeat(Math.max(0, this.getInputCount() - 1)) +
                ")");
    }
}
