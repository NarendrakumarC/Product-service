package com.textile.product_service.inheritancdemo.mapped_superclass;

import jakarta.persistence.Entity;

@Entity(name = "msc_instructors")
public class Instructor extends User {
    private String subject;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
