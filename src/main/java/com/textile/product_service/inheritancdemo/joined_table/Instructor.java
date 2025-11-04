package com.textile.product_service.inheritancdemo.joined_table;

import jakarta.persistence.Entity;

@Entity(name = "jt_instructors")
public class Instructor extends User {
    private String subject;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
