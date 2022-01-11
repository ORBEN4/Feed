package com.example.feedserver.memorymanagers.datastructure.sql;

import java.sql.Connection;
import java.sql.Statement;

public interface Statementable {
    public Statement build(Connection connection) throws Exception;

    public Integer getInputCount();
}
