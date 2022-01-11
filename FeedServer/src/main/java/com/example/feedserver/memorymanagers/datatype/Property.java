package com.example.feedserver.memorymanagers.datatype;

public class Property{
    private Object value;
    private Integer type;

    public Property(Object value, Integer type) {
        this.value = value;
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public Integer getType() {
        return type;
    }
}
