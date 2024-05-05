package com.gkcode.bookstore.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Table
@Getter
@Setter
@Entity(name = "bookOrder")
@NoArgsConstructor
@Component
public class Order {
    @Autowired
    public Order(List<Integer> bookList) {
        this.bookList = bookList;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String userName;
    @ElementCollection
    private List<Integer> bookList;
    private Double totalPrice;

}
