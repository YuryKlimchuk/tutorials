package com.hydroyura.BreadcrumbsGenerating.Controllers;

import com.hydroyura.BreadcrumbsGenerating.Breadcrumbs.BreadcrumbsItem;
import com.hydroyura.BreadcrumbsGenerating.Breadcrumbs.BreadcrumbsManager;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

public abstract class AbstractController {

    private BreadcrumbsManager breadcrumbsManager;

    public AbstractController(BreadcrumbsManager breadcrumbsManager) {
        this.breadcrumbsManager = breadcrumbsManager;
    }

    @ModelAttribute(name = "breadcrumbs")
    public Collection<BreadcrumbsItem> getBreadcrumbs(HttpServletRequest request) {
        return breadcrumbsManager.generateBreadcrumbs(request);
    }

}