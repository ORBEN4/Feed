package com.example.feedserver.memorymanagers.usersmemorymanager;

import com.example.feedserver.helpers.Idable;
import com.example.feedserver.memorymanagers.RamMemoryManager;
import com.example.feedserver.registration.datastructure.User;

public class UserRamMemoryManager extends RamMemoryManager<User> {
    @Override
    public User addObject(User user) throws Exception {
        return super.addObject(user);
    }
}
