package com.eray.erdem.readingisgood.statistic.service;

import com.eray.erdem.readingisgood.book.repository.BookRepository;
import com.eray.erdem.readingisgood.customer.repository.CustomerRepository;
import com.eray.erdem.readingisgood.order.model.Order;
import com.eray.erdem.readingisgood.order.repository.OrderRepository;
import com.eray.erdem.readingisgood.statistic.Statistic;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class StatisticServiceImpl implements StatisticService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final BookRepository bookRepository;


    @Override
    public void getOrdersByDate(String customerId) {
        List<Order> allByCustomer_id = orderRepository.findAllByCustomer_Id(customerId);

        // throw exception in here
        Map<String, List<Order>> listMap = new HashMap<>();
        allByCustomer_id.forEach(e -> {
            Date orderDate = e.getOrderDate();
            LocalDate localDate = orderDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            String format = String.format("%d-%d", localDate.getYear(), localDate.getMonthValue());
            List<Order> orders = listMap.get(format);
            if (orders == null) {
                List<Order> orderobject = new ArrayList<>();
                listMap.put(format, orderobject);
                orderobject.add(e);
            } else {
                orders.add(e);
            }

        });

        listMap.forEach((s, orders) -> {
            Statistic statistic = new Statistic();
            statistic.setDate(s);
            statistic.setOrderCount(orders.size());
            orders.forEach(
                    e -> {
                        double sum = e.getItems().stream().mapToDouble(x -> {
                            int amount = x.getAmount();
                            statistic.sumBookCount(amount);
                            return x.getPrice() * amount;
                        }).sum();
                        statistic.setAmount(sum);
                    });
        });
        System.out.println(allByCustomer_id);
    }
}
