package com.example.feedserver.memorymanagers.datastructure.sql;

import com.example.feedserver.helpers.FeedException;

import java.sql.Connection;
import java.sql.Statement;

public interface Statementable {
    Statement build(Connection connection) throws FeedException;

    Integer getInputCount();
}
