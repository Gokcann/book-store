package com.gkcode.bookstore;

import com.gkcode.bookstore.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.gkcode.bookstore.model.Book;

import java.util.Arrays;


@SpringBootApplication
public class BookStoreApplication implements CommandLineRunner {

	private final BookRepository bookRepository;

    public BookStoreApplication(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book book1 = new Book();
		Book book2 = new Book();

		book1.setName("Yuzuklerin Efendisi");
		book1.setAuthor("JRR Tolkien");
		book1.setPrice(10.0);
		book1.setStock(10);

		book2.setName("Baslangic");
		book2.setAuthor("Dan Brown");
		book2.setPrice(11.1);
		book2.setStock(10);

		bookRepository.saveAll(Arrays.asList(book1,book2));
	}
}
