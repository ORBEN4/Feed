package com.example.feedserver.routes;

import com.example.feedserver.constant.Controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

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
    @PreAuthorize("hasAuthority('APPROLE_Admin')")
    public String Admin() {
        return "Admin message";
    }
}

