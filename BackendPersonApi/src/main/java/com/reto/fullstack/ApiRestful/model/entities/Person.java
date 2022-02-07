package com.reto.fullstack.ApiRestful.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reto.fullstack.ApiRestful.model.dtos.PersonDto;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name="person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String fullname;
    private Date birth;
    private String father;
    private String mother;
    private String child;


    public Person() {
    }

    public Person(String fullname, Date birth, String father, String mother, String child) {
        this.fullname = fullname;
        this.birth = birth;
        this.father = father;
        this.mother = mother;
        this.child = child;
    }

    public void update(PersonDto personDto){
        this.fullname = personDto.getFullname();
        this.birth = personDto.getBirth();
        this.father = personDto.getFather();
        this.mother = personDto.getMother();
        this.child = personDto.getChild();


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
