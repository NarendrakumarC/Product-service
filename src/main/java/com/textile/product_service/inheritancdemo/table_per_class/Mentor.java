package com.textile.product_service.inheritancdemo.table_per_class;

import jakarta.persistence.Entity;

@Entity(name = "tpc_mentors")
public class Mentor extends User {
    private String company;
    private Double avgRating;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(Double avgRating) {
        this.avgRating = avgRating;
    }
}
