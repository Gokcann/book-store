package com.gkcode.bookstore.service;

import com.gkcode.bookstore.model.Book;
import com.gkcode.bookstore.model.Order;
import com.gkcode.bookstore.repository.OrderRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final Logger logger = (Logger) LoggerFactory.getLogger(OrderService.class);

    private final BookService bookService;
    private final OrderRepository orderRepository;

    public OrderService(BookService bookService, OrderRepository orderRepository) {
        this.bookService = bookService;
        this.orderRepository = orderRepository;
    }


    public Order putAnOrder(List<Integer> bookIdList, String userName) {
        List<Optional<Book>> bookList = bookIdList.stream().map(bookService::findBookById).toList();

        Double totalPrice = bookList.stream().map(optionalBook -> optionalBook.map(Book::getPrice).orElse(0.0)).reduce(0.0,Double::sum);

    Order order = new Order();
    order.setBookList(bookIdList);
    order.setUserName(userName);
    order.setTotalPrice(totalPrice);

    return orderRepository.save(order);
    }


}
