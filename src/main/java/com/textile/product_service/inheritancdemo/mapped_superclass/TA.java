package com.textile.product_service.inheritancdemo.mapped_superclass;

import jakarta.persistence.Entity;

@Entity(name = "msc_tas")
public class TA extends User {
    private int numberOfHRs;
    private Double avgRating;

    public int getNumberOfHRs() {
        return numberOfHRs;
    }

    public void setNumberOfHRs(int numberOfHRs) {
        this.numberOfHRs = numberOfHRs;
    }

    public Double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(Double avgRating) {
        this.avgRating = avgRating;
    }
}
