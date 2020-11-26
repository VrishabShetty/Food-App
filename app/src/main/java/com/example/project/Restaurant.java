package com.example.project;

import java.net.URL;
import java.util.UUID;

public class Restaurant {

    private URL url;
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

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public void setName(String name) {
        this.name = name;
    }
}
