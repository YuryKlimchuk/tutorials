package com.hydroyura.BreadcrumbsGenerating.Controllers;

import com.hydroyura.BreadcrumbsGenerating.Breadcrumbs.BreadcrumbsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AccountController extends AbstractController {


    @Autowired
    public AccountController(@Qualifier(value = "AccountBreadcrumbsManager") BreadcrumbsManager breadcrumbsManager) {
        super(breadcrumbsManager);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/my-account")
    public String step1() {
        return "breadcrumbs/account_step1";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/my-account/personal-data")
    public String step2() {
        return "breadcrumbs/account_step2";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/my-account/personal-data/edit-info")
    public String step3() {
        return "breadcrumbs/account_step3";
    }

}