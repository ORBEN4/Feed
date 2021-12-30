package com.example.feedserver;

import com.example.feedserver.registration.memorymanager.MySqlMemoryManager;

public class TesterMain {
    public static void main(String[] args) {
        MySqlMemoryManager mySqlMemoryManager = new MySqlMemoryManager();
        System.out.println(1);
        System.out.println(mySqlMemoryManager.test("select * from users.genders"));

    }
}
