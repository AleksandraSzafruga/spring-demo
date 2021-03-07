package pl.sda.javalondek4springdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.javalondek4springdemo.dto.ExceptionResponse;
import pl.sda.javalondek4springdemo.exception.BookNotFoundException;
import pl.sda.javalondek4springdemo.model.Book;
import pl.sda.javalondek4springdemo.service.BookService;
import pl.sda.javalondek4springdemo.service.MyService;

import javax.persistence.PostUpdate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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
    public ResponseEntity<Void> deleteBookById(@PathVariable("id") Long id) {
        logger.info("deleting book by id: [{}]", id);
        boolean delete = bookService.deleteBookById(id);
        ResponseEntity<Void> result = ResponseEntity.notFound().build();
        if (delete) {
            return ResponseEntity.noContent().build();
        }
        return result;
    }

    //update - replace
    @PutMapping("/{id}")
    public Book replaceBook(@PathVariable("id") Long id, @RequestBody Book toReplace) {
        logger.info("replacing book with new one: [{}]", toReplace);
        return bookService.replaceBook(id, toReplace);
    }

    //update - partial
    @PatchMapping("/{id}")
    public Book updateBook(@PathVariable("id") Long id, @RequestBody Book toUpdate) {
        logger.info("updating Book with new attributes: [{}]", toUpdate);

        return bookService.updateBookWithAttributes(id, toUpdate);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleBookNotFoundException(Exception exception, HttpServletRequest request) {
        logger.warn("some unexpected exception has occurred :)", exception);
        return ResponseEntity.badRequest().body(
                new ExceptionResponse(LocalDateTime.now(Clock.systemUTC()),
                        HttpStatus.BAD_REQUEST.value(),
                        exception.getClass().getName(),
                        exception.getMessage(),
                        request.getServletPath())
        );
    }

}
