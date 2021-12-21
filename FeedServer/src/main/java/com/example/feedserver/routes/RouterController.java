package com.example.feedserver.routes;

import com.example.feedserver.constant.Controllers;
import org.reflections.Reflections;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(Controllers.ROOT)
public class RouterController {
    private final String domain = "http://localhost:8080";


    @GetMapping(path = {"", "/menu"})
    protected String menu() {
        StringBuilder menu = new StringBuilder("<h1>Main Menu</h1>");
//        Set<Class> classes = new HashSet(Arrays.asList(AuthenticationController.class, MasterController.class, TestController.class)).stream().map(((c)->menu.append(getAll((Class) c, 2))));
//        for (Class clazz :
//                classes)  {
//            menu.append(getAll(clazz, 2));
//        }
        new HashSet(Arrays.asList(AuthenticationController.class, MasterController.class, TestController.class)).stream().map(((c) -> menu.append(getAll((Class) c, 2))));
        return menu.toString();
    }

    protected String getAll(Class clazz) {
        return this.getAll(clazz, 1);
    }

    private String getAll(Class clazz, Integer headlineSize) {
        StringBuilder stringBuilder = new StringBuilder("<h" + headlineSize.toString() + ">" + clazz.getSimpleName().substring(0, clazz.getSimpleName().indexOf("Controller")) + "</h" + headlineSize.toString() + ">");
        Object[] methodsList = getMethodsList(clazz);
        for (int i = 0; i < methodsList.length - 9; i++) {
            stringBuilder.append(methodsList[i]);
        }
        return stringBuilder.toString();
    }

    private Object[] getMethodsList(Class clazz) {
        // TODO: 15/12/2021 might cause exception
        return Arrays.stream(clazz.getMethods()).map(u -> "<br><a href=\"" + domain + "/" + clazz.getSimpleName().substring(0, clazz.getSimpleName().indexOf("Controller")) + "/" + u.getName() + "\">" + u.getName() + "</a>").toArray();
    }

//    protected String getAllOld(Class aClass) {
//        Object[] domainArray = Arrays.stream(aClass.getMethods()).map(u -> "<br><a href=\"" + domain + "/" + aClass.getSimpleName() + "/" + u.getName() + "\">" + u.getName() + "</a>").toArray();
//        StringBuilder stringBuilder = new StringBuilder("<h1>" + aClass.getSimpleName() + "</h1>");
//        for (int i = 0; i < domainArray.length - 9; i++) {
//            stringBuilder.append(domainArray[i]);
//        }
//        return stringBuilder.toString();
//    }


}
