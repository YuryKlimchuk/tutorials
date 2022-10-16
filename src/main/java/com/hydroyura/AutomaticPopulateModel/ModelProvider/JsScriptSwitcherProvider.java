package com.hydroyura.AutomaticPopulateModel.ModelProvider;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class JsScriptSwitcherProvider implements IModelProvider {

    private boolean flag;

    @PostConstruct
    void init() {
        flag = true;
    }

    @Override
    public Object getData() {
        return flag;
    }

    @Override
    public String getLabel() {
        return "isJsScriptEnable";
    }
}
