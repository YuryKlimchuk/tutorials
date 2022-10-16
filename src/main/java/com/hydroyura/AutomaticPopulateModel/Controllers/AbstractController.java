package com.hydroyura.AutomaticPopulateModel.Controllers;

import com.hydroyura.AutomaticPopulateModel.ModelProvider.IModelProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractController {

    @Autowired
    private Collection<IModelProvider> providers = new ArrayList<>();

    @ModelAttribute(name = "automaticData")
    public Map<String, Object> getAutomaticData() {
        return providers.stream().collect(Collectors.toMap(IModelProvider::getLabel, IModelProvider::getData));
    }

}