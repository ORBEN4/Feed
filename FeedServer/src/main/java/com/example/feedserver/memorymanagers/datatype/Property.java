package com.example.feedserver.memorymanagers.datatype;

public class Property{
    private final Object value;
    private final Integer type;

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
