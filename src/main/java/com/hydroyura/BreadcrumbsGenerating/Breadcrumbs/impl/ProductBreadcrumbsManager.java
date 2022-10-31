package com.hydroyura.BreadcrumbsGenerating.Breadcrumbs.impl;

import com.hydroyura.BreadcrumbsGenerating.Breadcrumbs.BreadcrumbsManager;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.regex.Pattern;

@Component(value = "ProductBreadcrumbsManager")
public class ProductBreadcrumbsManager extends BreadcrumbsManager {

    @Override
    public void init() {
        this.template = new HashMap<>();
        template.put(Pattern.compile("products-list"), "Products");
        template.put(Pattern.compile("[0-9]+"), "Product detail info");
        template.put(Pattern.compile("edit-product-data"), "Edit product");
    }

}