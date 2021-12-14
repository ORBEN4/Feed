package com.example.feedserver.memorymanagers;

import com.example.feedserver.helpers.Idable;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class RamMemoryManager<T extends Idable> implements MemoryManager<T>{
    private final Map<String, T> objects;

    public RamMemoryManager() {
        this.objects = new HashMap<>();
    }

    @Override
    public T addObject(T t) throws Exception {
        if (!this.objects.containsKey(t.getId())) {
            this.objects.put(t.getId(), t);
        } else {
            throw new Exception();
            // TODO: 29/11/2021 add custom exception
        }
        return t;
    }

    public T getObject(String id) throws Exception {
        if (this.objects.containsKey(id)) {
            return this.objects.get(id);
        } else {
            throw new Exception();
            // TODO: 29/11/2021 add custom exception
        }
    }

    public T removeObject(String id) throws Exception {
        if (this.objects.containsKey(id)) {
            return this.objects.remove(id);
        } else {
            throw new Exception();
            // TODO: 29/11/2021 add custom exception
        }
    }

    public Collection<T> getAll(){
        if (!this.objects.isEmpty()){
            return this.objects.values();
        }
        else return new HashSet<>();
    }
}
