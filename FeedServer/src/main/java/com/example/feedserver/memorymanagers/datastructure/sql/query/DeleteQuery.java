package com.example.feedserver.memorymanagers.datastructure.sql.query;

import com.example.feedserver.memorymanagers.datastructure.sql.QueryType;
import com.example.feedserver.memorymanagers.datatype.Property;

import java.text.MessageFormat;
import java.util.ArrayList;

public class DeleteQuery extends Query{
    public DeleteQuery(String schemaName, String tableName, QueryType type, ArrayList<Property> parameters) {
        super(schemaName, tableName, type, parameters);
    }
    @Override
    String buildQueryStructure() {
        return MessageFormat.format(this.type.getQuery(), this.schemaName, this.tableName);
    }
}
