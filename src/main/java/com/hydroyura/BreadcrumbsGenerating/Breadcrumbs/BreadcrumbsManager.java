package com.hydroyura.BreadcrumbsGenerating.Breadcrumbs;

import org.springframework.http.HttpRequest;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public abstract class BreadcrumbsManager {


    protected Map<Pattern, String> template;
    private String defaultValue = "default";


    public Collection<BreadcrumbsItem> generateBreadcrumbs(HttpServletRequest request) {
        String URL = request.getRequestURI();
        List<String> uri = Arrays.stream(URL.split("/")).collect(Collectors.toList());

        String hostName = request.getScheme() + "://" + request.getServerName() + ":" +  request.getServerPort();

        if(uri.isEmpty()) Collections.emptyList();

        Collection<BreadcrumbsItem> result = new ArrayList<>();

        for (int i = 1; i < uri.size(); i++) {
            BreadcrumbsItem breadcrumbsItem = new BreadcrumbsItem(
                    hostName + getLink(uri.get(i), uri),
                    getTitle(uri.get(i))
            );
            result.add(breadcrumbsItem);
        }

        return result;
    }

    private String getTitle(String value) {
        Optional<Pattern> result = template.keySet().stream()
                .filter(item -> {
                        Matcher matcher = item.matcher(value);
                        return matcher.find();
                    })
                .findFirst();
        if(result.isPresent()) return template.get(result.get());
        return defaultValue;
    }

    private String getLink(String value, Collection<String> uri) {
        String link = "";

        for(String item: uri) {
            link = link.concat("/" + item);
            if(item.equals(value)) break;
        }

        return link.substring(1);
    }

    @PostConstruct
    abstract protected void init();

}