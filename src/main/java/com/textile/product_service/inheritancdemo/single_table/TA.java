package com.textile.product_service.inheritancdemo.single_table;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name = "st_tas")
@DiscriminatorValue(value = "3")
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
