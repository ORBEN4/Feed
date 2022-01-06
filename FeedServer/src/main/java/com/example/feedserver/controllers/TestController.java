package com.example.feedserver.controllers;

import com.example.feedserver.FeedServerApplication;
import com.example.feedserver.constant.Controllers;
import com.example.feedserver.registration.memorymanager.MySqlMemoryManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping(Controllers.TEST)
public class TestController extends RouterController {

    @Override
    @GetMapping(path = {"", "/menu"})
    public String menu() {
        return super.getAll(this.getClass());
    }

    @GetMapping("/Admin")
    @ResponseBody
//    @PreAuthorize("hasAuthority('APPROLE_Admin')")
    public String Admin() {
        return "Admin message";
    }


    @GetMapping("SQL")
    public Object tryToConnect(String rawQuery) {

        MySqlMemoryManager mySqlMemoryManager = new MySqlMemoryManager();
//        return mySqlMemoryManager.test("select * from users.genders");
        return mySqlMemoryManager.test(rawQuery);
//        return new MySqlMemoryManager().test(rawQuery);
    }

    @GetMapping("kill")
    public ResponseEntity kill() {
//        FeedServerApplication.starter.close();
//        System.out.println("close");

        new Thread() {
            @Override
            public void run() {

                super.run();
                FeedServerApplication.starter.stop();
            }
        }.start();

        return new ResponseEntity<>("<h1>success<h1/>", HttpStatus.OK);
    }
}

