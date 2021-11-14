package com.eray.erdem.readingisgood.statistic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class Statistic {
    private String date;
    private int orderCount;
    private int bookCount;
    private double amount;


    @JsonIgnore
    public void sumBookCount(int count) {
        bookCount += count;
    }
}
