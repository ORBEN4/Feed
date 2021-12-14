package com.example.feedserver.routes;

import com.example.feedserver.memorymanagers.MemoryManager;
import com.example.feedserver.memorymanagers.RamMemoryManager;
import com.example.feedserver.registration.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/authentication")
public class AuthenticationRouter {
    MemoryManager<User> users = new RamMemoryManager<>();

    @GetMapping("/greet")
    public String greet(String name) {
        return "hi " + name;
    }

    @GetMapping("/register")
    public Object register(String username, String password, String email) {
        try {
            return this.users.addObject(new User(username, password, email));
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping("/getall")
    public Collection<User> getAll(){
        return this.users.getAll();
    }
}
