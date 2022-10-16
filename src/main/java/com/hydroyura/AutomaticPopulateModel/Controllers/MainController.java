package com.hydroyura.AutomaticPopulateModel.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
public class MainController extends AbstractController {

    @GetMapping
    public String indexGET() {
        return "index";
    }

}
