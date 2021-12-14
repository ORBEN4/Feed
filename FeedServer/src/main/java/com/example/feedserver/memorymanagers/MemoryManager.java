package com.example.feedserver.memorymanagers;

import com.example.feedserver.helpers.Idable;

import java.util.Collection;

public interface MemoryManager<T extends Idable> {
    T addObject(T t) throws Exception;

    T getObject(String id) throws Exception;

    T removeObject(String id) throws Exception;

    public Collection<T> getAll();
}
