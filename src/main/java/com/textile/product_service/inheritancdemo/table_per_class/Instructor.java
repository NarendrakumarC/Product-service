package com.textile.product_service.inheritancdemo.table_per_class;

import jakarta.persistence.Entity;

@Entity(name = "tpc_instructors")
public class Instructor extends User {
    private String subject;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
