package com.example.feedserver.controllers;

import com.example.feedserver.FeedServerApplication;
import com.example.feedserver.constant.Controllers;
import com.example.feedserver.helpers.ConfigurationManager;
import com.example.feedserver.memorymanagers.MySqlMemoryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping(Controllers.TEST)
public class TestController extends RouterController {
//    @Autowired
//    private Environment environment;

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
        return mySqlMemoryManager.testReadQuery(rawQuery);
//        return new MySqlMemoryManager().test(rawQuery);
    }

    @GetMapping("kill")
    public ResponseEntity<String> kill() {
//        FeedServerApplication.starter.close();
//        System.out.println("close");

        new Thread() {
            @Override
            public void run() {

                super.run();
                FeedServerApplication.starter.stop();
            }
        }.start();

        return new ResponseEntity<>("<body style= \"background-color:chartreuse\" ><h1><b>success</b></h1></body>", HttpStatus.OK);
    }

    @GetMapping(path = "getDriverName")
    public ResponseEntity getDriverName(){
        try {
            return new ResponseEntity<>(ConfigurationManager.getInstance().getProperty("feed.micro-services.registration.database.driver.name"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(path = "environment")
    public ResponseEntity environment(){
        try {
            return new ResponseEntity<>(ConfigurationManager.getInstance().getProperty("feed.micro-services.registration.database.driver.name"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "environmentInput")
    public ResponseEntity environmentInput(@RequestHeader("key") String key){
        try {
            return new ResponseEntity<>(ConfigurationManager.getInstance().getProperty(key), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "environmentIsInitialized")
    public ResponseEntity environmentIsInitialized(){
        try {
            return new ResponseEntity<>(ConfigurationManager.getInstance().isInitialized(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

