package com.natsuyami.inventory.config.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

public class SwaggerAggregateProvider implements SwaggerResourcesProvider {

    @Value("${server.servlet.context-path}")
    private String basePath;

    @Override
    public List<SwaggerResource> get() {
        ArrayList<SwaggerResource> resources = new ArrayList<SwaggerResource>();

        SwaggerResource productApi = new SwaggerResource();
        productApi.setName("Product Endpoints");
        productApi.setUrl(basePath + "/swagger.json");
        productApi.setLocation(basePath + "/swagger.json");
        productApi.setSwaggerVersion("2.0");

        resources.add(productApi);

        return resources;
    }
}
