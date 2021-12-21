package com.example.feedserver.routes;

import com.example.feedserver.constant.Controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Controllers.MASTER)
public class MasterController extends RouterController {


    @Override
    @GetMapping(path = {"", "/menu"})
    public String menu() {
        return super.getAll(this.getClass());
    }

//    public void onApplicationEvent(ContextRefreshedEvent event) {
//        ApplicationContext applicationContext = event.getApplicationContext();
//        RequestMappingHandlerMapping requestMappingHandlerMapping = applicationContext.getBean("requestMappingHandlerMapping", RequestMappingHandlerMapping.class);
//        Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();
//        map.forEach((key, value) -> System.out.println("{} {}, key: " + key + ". value: " + value));
//    }


    @GetMapping("/test1")
    public String test1() {
        return "<h1>Hello</h1>";
    }

    @GetMapping("/test2")
    public String test2() {
        return "answer 2";
    }

    @GetMapping("/test3")
    public String test3() {
        return "answer 3";
    }

    @GetMapping("/test4")
    public String test4() {
        return "answer 4";
    }

    @GetMapping("/test5")
    public String test5() {
        return "answer 5";
    }
}
