package com.reto.fullstack.ApiRestful.model.entities;

import java.util.Date;
import java.util.List;

public class Person {
    private String fullname;
    private Date birth;
    private List children;
    private String mother;
    private String father;

    public Person() {
    }

    public Person(String fullname, Date birth) {
        this.fullname = fullname;
        this.birth = birth;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public List getChildren() {
        return children;
    }

    public void setChildren(List children) {
        this.children = children;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }
}
