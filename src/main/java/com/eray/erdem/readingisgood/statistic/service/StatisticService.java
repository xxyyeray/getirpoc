package com.eray.erdem.readingisgood.statistic.service;

import com.eray.erdem.readingisgood.order.model.Order;
import com.eray.erdem.readingisgood.order.model.OrderCreate;
import com.eray.erdem.readingisgood.order.model.OrderDetail;

import java.util.Date;
import java.util.List;

public interface StatisticService {


    void getOrdersByDate(String customerId);
}
