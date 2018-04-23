package com.example.kirannaidu.studentbenfits;

/**
 * Created by user on 3/27/2018.
 */

public class Filename {
    private String id,url,name;

    public Filename(String id, String name, String url) {
        this.id = id;
        this.url = url;
        this.name = name;
    }

    public Filename(String s, String toString) {
    }

    public Filename() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
