package com.gkcode.bookstore.repository;

import com.gkcode.bookstore.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface OrderRepository extends JpaRepository<Order,Integer> {
}
