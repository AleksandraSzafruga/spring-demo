package pl.sda.javalondek4springdemo.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.sda.javalondek4springdemo.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private static final Logger logger = LoggerFactory.getLogger(BookRepository.class);
    private List<Book> books;

    public BookRepository() {
        List<Book> someBooks = List.of(
                new Book (1L, "Tolkien", "Władca Pierścieni"),
                new Book (2L, "Sapkowski","Pani Jeziora"),
                new Book (3L, "Sienkiewicz", "Quo vadis")

        );
        this.books = new ArrayList<>(someBooks);
        logger.info("book repository initialized with books: {}", books);
    }
}
