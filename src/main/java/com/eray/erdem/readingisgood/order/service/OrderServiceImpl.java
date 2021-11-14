package com.eray.erdem.readingisgood.order.service;

import com.eray.erdem.readingisgood.book.exception.BookNotFoundException;
import com.eray.erdem.readingisgood.book.exception.InsufficientStockException;
import com.eray.erdem.readingisgood.book.exception.OutOfStockException;
import com.eray.erdem.readingisgood.book.model.Book;
import com.eray.erdem.readingisgood.book.repository.BookRepository;
import com.eray.erdem.readingisgood.customer.exception.CustomerNotFoundException;
import com.eray.erdem.readingisgood.customer.model.Customer;
import com.eray.erdem.readingisgood.customer.repository.CustomerRepository;
import com.eray.erdem.readingisgood.order.exception.OrderNotFoundException;
import com.eray.erdem.readingisgood.order.model.*;
import com.eray.erdem.readingisgood.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final BookRepository bookRepository;

    @Override
    public OrderDetail createOrder(OrderCreate order) {


        Optional<Customer> byId = customerRepository.findById(order.getCustomerNumber());
        if (byId.isEmpty()) {
            throw new CustomerNotFoundException(order.getCustomerNumber());
        }
        Customer customer = byId.get();
        List<OrderItem> items = order.getBooks();
        List<Book> books = new ArrayList<>();
        items.forEach(e -> {
            String isbn = e.getIsbn();
            Integer amount = e.getAmount();
            Optional<Book> byIsbn = bookRepository.findByIsbn(isbn);

            isBookExist(isbn, byIsbn);
            Book book = byIsbn.get();
            books.add(book);
            int stock = book.getStock();
            isBuyableBook(isbn, amount, stock);
            e.setPrice(book.getPrice());
            book.setStock(stock - amount);
            bookRepository.save(book);
        });

        log.info("Order creating  for customer ", order.getCustomerNumber());
        Order orderEntity = Order.builder()
                .customer(customer)
                .orderStatus(OrderStatus.PREPARING)
                .orderDate(new Date())
                .items(order.getBooks())
                .customer(customer)
                .build();

        Order savedOrder = orderRepository.insert(orderEntity);

        log.info("Order created  for customer ", order.getCustomerNumber());
        return new OrderDetail(savedOrder.getId());


    }

    private void isBookExist(String isbn, Optional<Book> byIsbn) {
        if (byIsbn.isEmpty()) {
            log.error("Book Not Found {}", isbn);
            throw new BookNotFoundException(isbn);
        }
    }

    private void isBuyableBook(String isbn, Integer amount, int stock) {
        if (stock == 0) {
            log.error("The book was out of stock. {}", isbn);
            throw new OutOfStockException(isbn);
        } else if (amount > stock) {
            log.error("insufficient stock ,  number of purchases {}  stock quantity {}", amount, stock);
            throw new InsufficientStockException(amount, stock, isbn);
        }
    }


    @Override
    public Order getOrder(String id) {
        log.info("Orders query  which id is {}", id);
        Optional<Order> byId = orderRepository.findById(id);
        return byId.orElseThrow(() -> new OrderNotFoundException(id));
    }

    @Override
    public List<Order> getOrdersByDate(Date startDate, Date endDate) {
        log.info("Orders query  between dates {} and  {}", startDate, endDate);
        return orderRepository.findAllByOrderDateBetween(startDate, endDate);

    }


}
