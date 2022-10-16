package com.hydroyura.AutomaticPopulateModel.ModelProvider;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ShowBannerProviderProvider implements IModelProvider {

    private boolean isBannerShow;

    @PostConstruct
    void init() {
        isBannerShow = true;
    }

    @Override
    public Object getData() {
        return isBannerShow;
    }

    @Override
    public String getLabel() {
        return "isBannerShow";
    }
}
