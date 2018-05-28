package com.example.minhquang.objectboxdemo.Models;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Student {
    @Id(assignable = true)
    Long id;
    String name;
    String age;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
