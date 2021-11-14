package com.eray.erdem.readingisgood.statistic.service;

import com.eray.erdem.readingisgood.statistic.Statistic;

import java.util.List;

public interface StatisticService {


    List<Statistic> getOrdersByDate(String customerId);
}
