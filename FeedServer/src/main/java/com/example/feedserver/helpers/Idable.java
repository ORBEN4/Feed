package com.example.feedserver.helpers;

import java.util.UUID;

public interface Idable {
    String getId();

    default String generateId(){
        return UUID.randomUUID().toString();
    }
}
