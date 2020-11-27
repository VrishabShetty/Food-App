package com.example.project;

import java.net.URL;
import java.util.UUID;

public class Restaurant {

    private String url;
    private String name;
    private UUID id;

    public Restaurant() {
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setName(String name) {
        this.name = name;
    }
}
