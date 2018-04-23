package com.example.kirannaidu.studentbenfits;

/**
 * Created by kiran naidu on 3/19/2018.
 */

public class subjects {
    private String subid;
    private String subname;

    public subjects(String subid, String subname) {
        this.subid = subid;
        this.subname = subname;
    }

    public subjects() {
    }

    public void setSubid(String subid) {
        this.subid = subid;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }

    public String getSubid() {
        return subid;
    }

    public String getSubname() {
        return subname;
    }
}
