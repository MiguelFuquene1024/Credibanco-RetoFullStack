package com.reto.fullstack.ApiRestful.model.dtos;

import java.util.Date;

public class PersonDto {
    private String fullname;
    private Date birth;

    public PersonDto() {
    }

    public PersonDto(String fullname, Date birth) {
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
}
