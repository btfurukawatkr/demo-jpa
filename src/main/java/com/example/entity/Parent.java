package com.example.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Parent {

    @Id
    @GeneratedValue
    private int id;

    @OneToMany(mappedBy = "parent")
    private List<Child> children = new LinkedList<Child>();

    public int getId() {
        return id;
    }

    public Parent() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

}
