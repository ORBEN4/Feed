package com.example.feedserver.routes;

import com.example.feedserver.constant.Controllers;
import com.example.feedserver.memorymanagers.MemoryManager;
import com.example.feedserver.memorymanagers.RamMemoryManager;
import com.example.feedserver.registration.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Controllers.AUTHENTICATION)
public class AuthenticationController extends RouterController {
    MemoryManager<User> users = new RamMemoryManager<>();

//    @GetMapping("/greet")
//    public String greet(String name) {
//        return "hi " + name;
//    }

//    @GetMapping("/register")
//    public Object register(String username, String password, String email) {
//        try {
//            return this.users.addObject(new User(username, password, email));
//        } catch (Exception e) {
//            return e.getMessage();
//        }
//    }

//    @GetMapping("/getall")
//    public Collection<User> getAll(){
//        return this.users.getAll();
//    }

    @Override
    @GetMapping(path = {"", "/menu"})
    public String menu() {
        return super.getAll(this.getClass());
    }

    @GetMapping("Admin")
    @ResponseBody
    @PreAuthorize("hasAuthority('APPROLE_Admin')")
    public String Admin() {
        return "Admin message";
    }

    @GetMapping("/register")
    public Object register(String personalNumber, String password) {
        try {
            return this.users.addObject(new User(personalNumber, password));
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
