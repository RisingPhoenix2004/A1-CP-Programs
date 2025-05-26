package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Student {
    private int sid;
    private String sname;
    public Student() {
        super();
        System.out.println("Student object created");
    }
    public void setSid(int sid) {
        this.sid = sid;
    }
    public int getSid() {
        return sid;
    }
    public void setSname(String sname) {
        this.sname = sname;
    }
    public String getSname() {
        return sname;
    }
    public void print(){
        System.out.println("Printing");
    }
}
