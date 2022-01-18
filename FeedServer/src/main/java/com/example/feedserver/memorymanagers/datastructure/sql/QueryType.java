package com.example.feedserver.memorymanagers.datastructure.sql;

public enum QueryType {
    /**
     * DQL - select query
     */
    SELECT("SELECT {2} FROM {0}.{1}", "DQL", 2),
    /**
     * TCL - Transaction control language (handle transaction inside the database)
     */
    COMMIT("COMMIT", "TCL", -1),
    ROLLBACK("ROLLBACK", "TCL", -1),
    @Deprecated
    SAVE_POINT("SAVE POINT", "TCL", -1),
    /**
     * DML - Data Manipulation Language (manipulate values in the database)
     */
    INSERT_VALUE("INSERT INTO {0}.{1} VALUE {2}", "DML", 2),
    INSERT_VALUES("INSERT INTO {0}.{1} VALUES {2}", "DML", 2),
    UPDATE("UPDATE {0}.{1} SET {2}", "DML", 2),
    DELETE("DELETE FROM {0}.{1}", "DML", 1),
    /**
     * DCL - Data Control Language (permission control)
     */
    GRANT("GRANT", "DCL", -1),
    REVOKE("REVOKE", "DCL", -1),
    /**
     * DDL - Data Definition Language (modify the database structure)
     */
    CREATE("CREATE", "DDL", -1),
    DROP("DROP", "DDL", -1),
    ALTER("ALTER", "DDL", -1),
    TRUNCATE("TRUNCATE", "DDL", -1);


    private final String query;
    private final String type;
    private Integer lastIndex;

    QueryType(String query, String type, Integer lastIndex) {
        this.query = query;
        this.type = type;
        this.lastIndex = lastIndex;
    }

    public String getType() {
        return type;
    }

    public String getQuery() {
        return query;
    }

    @org.jetbrains.annotations.NotNull
    @org.jetbrains.annotations.Contract(mutates = "this")
    public String getQueryWithCondition() {
        lastIndex++;
        return query + " WHERE {" + lastIndex + "}";
    }
}
