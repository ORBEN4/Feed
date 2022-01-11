package com.example.feedserver.helpers;

@Deprecated
public class Property<T> {
    private T value;
    private String type;

    public Property(T value) {
        this.type = value.getClass().getSimpleName();
        this.value = value;
    }

    public Property(T value, String type) {
        this.value = value;
        this.type = type;
    }

    public T getValue() {
        return this.value;
    }

    public String getType() {
        return this.type;
    }
}
