package com.reto.fullstack.ApiRestful.model.dtos;

import com.reto.fullstack.ApiRestful.model.entities.Person;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class PersonDto {
    private String fullname;
    private Date birth;
    private String father;
    private String mother;
    private String child;

    public PersonDto() {
    }


    public PersonDto(String fullname, Date birth, String father, String mother, String child) {
        this.fullname = fullname;
        this.birth = birth;
        this.father = father;
        this.mother = mother;
        this.child = child;
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

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }
}
