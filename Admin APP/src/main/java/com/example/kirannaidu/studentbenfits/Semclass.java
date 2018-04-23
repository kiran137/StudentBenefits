package com.example.kirannaidu.studentbenfits;

/**
 * Created by kiran naidu on 3/17/2018.
 */

public class Semclass {
   public String id;
     public String branch;
     public String yearsem;


    public Semclass(String id, String branch, String yearsem) {
        this.id = id;
        this.branch = branch;
        this.yearsem = yearsem;

    }

    public Semclass() {

    }


    public String getId() {
        return id;
    }

    public String getBranch() {
        return branch;
    }

    public String getYearsem() {
        return yearsem;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setYearsem(String yearsem) {
        this.yearsem = yearsem;
    }
}
