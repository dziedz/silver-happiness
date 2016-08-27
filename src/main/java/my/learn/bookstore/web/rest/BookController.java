package my.learn.bookstore.web.rest;


import my.learn.bookstore.domain.Book;
import my.learn.bookstore.domain.Isbn;
import my.learn.bookstore.domain.Reviewer;
import my.learn.bookstore.repository.BookRepository;
import my.learn.bookstore.web.rest.propertyeditor.IsbnEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @RequestMapping(value = "/{isbn}", method =
            RequestMethod.GET)
    public Book getBook(@PathVariable Isbn isbn) {
        return bookRepository.findBookByIsbn(isbn.getIsbn());
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Isbn.class, new IsbnEditor());
    }

    @RequestMapping(value = "/{isbn}/reviewers", method = RequestMethod.GET)
    public List<Reviewer> getReviewers(@PathVariable("isbn") Book book) {
        return book.getReviewers();
    }

    @RequestMapping(value = "/session", method = RequestMethod.GET)
    public String getSessionId(HttpServletRequest request) {
        return request.getSession().getId();
    }
}