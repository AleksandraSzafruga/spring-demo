package pl.sda.javalondek4springdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.javalondek4springdemo.model.Book;
import pl.sda.javalondek4springdemo.service.BookService;
import pl.sda.javalondek4springdemo.service.MyService;

import javax.persistence.PostUpdate;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping
    public List<Book> getAllBooks() {
        logger.info("getAllBooks()");

        return bookService.findAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") Long id) {
        logger.info("find book by Id: [{}]", id);
        return bookService.findBookById(id);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book toSave) {
        logger.info("adding book: [{}]", toSave);
        var newBook = bookService.saveBook(toSave);
        return ResponseEntity.created(URI.create("books/" + newBook.getId()))
                .body(newBook);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable("id") Long id) {
        logger.info("deleting book by id: [{}]", id);
        bookService.deleteBookById(id);
    }

    //update - replace
    @PutMapping("/{id}")
    public Book replaceBook(@PathVariable ("id") Long id, @RequestBody Book toReplace) {
        logger.info("replacing book with new one: [{}]", toReplace);
        return bookService.replaceBook(id, toReplace);
    }

    //update - partial
    @PatchMapping("/{id}")
    public Book updateBook (@PathVariable ("id") Long id, @RequestBody Book toUpdate) {
        logger.info("updating Book with new attributes: [{}]", toUpdate);

        return bookService.updateBookWithAttributes(id, toUpdate);
    }

}
