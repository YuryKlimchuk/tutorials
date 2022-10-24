package com.hydroyura.AutomaticPopulateModel.ModelProvider;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class CredentialsProvider implements IModelProvider {
    private Map<String, String> credentials;
    @PostConstruct
    void init() {
        credentials = new HashMap<>();
        credentials.put("userName", "user");
        credentials.put("role", "simple-user");
    }
    @Override
    public Object getData() {
        return credentials;
    }
    @Override
    public String getLabel() {
        return "credentials";
    }
}
