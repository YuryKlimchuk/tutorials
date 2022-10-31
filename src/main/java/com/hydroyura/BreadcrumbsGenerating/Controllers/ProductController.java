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
public class ProductController extends AbstractController {

    @Autowired
    public ProductController(@Qualifier(value = "ProductBreadcrumbsManager") BreadcrumbsManager breadcrumbsManager) {
        super(breadcrumbsManager);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/products-list")
    public String step1() {
        return "breadcrumbs/products_step1";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/products-list/{id}")
    public String step2(@PathVariable(name = "id") long id, Model model) {
        model.addAttribute("product_id", id);
        return "breadcrumbs/products_step2";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/products-list/{id}/edit-product-data")
    public String step3(@PathVariable(name = "id") long id, Model model) {
        model.addAttribute("product_id", id);
        return "breadcrumbs/products_step3";
    }

}
