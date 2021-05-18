package com.example.studyhubtanishq;

public class Course {
    private String name ;
    private String code;
    private int credits;
    private int modules;

    public Course(String name, String code, int credits, int modules){
        this.name = name;
        this.code = code;
        this.credits = credits;
        this.modules = modules;
    }

    public int getModules() {
        return modules;
    }

    public void setModules(int modules) {
        this.modules = modules;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
