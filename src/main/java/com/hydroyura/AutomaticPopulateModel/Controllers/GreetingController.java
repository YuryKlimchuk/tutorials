package com.hydroyura.AutomaticPopulateModel.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingController extends AbstractController{

    @GetMapping(value = "/greeting")
    public String greetingGET() {
        return "greeting";
    }

}
