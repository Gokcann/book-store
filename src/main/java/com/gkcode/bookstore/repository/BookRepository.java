package com.gkcode.bookstore.repository;

import com.gkcode.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface BookRepository extends JpaRepository<Book, Integer> {
}
