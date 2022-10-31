package com.hydroyura.BreadcrumbsGenerating.Breadcrumbs.impl;

import com.hydroyura.BreadcrumbsGenerating.Breadcrumbs.BreadcrumbsManager;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.regex.Pattern;

@Component(value = "AccountBreadcrumbsManager")
public class AccountBreadcrumbsManager extends BreadcrumbsManager {

    @Override
    protected void init() {
        this.template = new HashMap<>();
        template.put(Pattern.compile("my-account"), "My Account");
        template.put(Pattern.compile("personal-data"), "Account personal data");
        template.put(Pattern.compile("edit-info"), "Edit account data");
    }

}