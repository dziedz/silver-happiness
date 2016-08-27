package my.learn;

import my.learn.bookstore.domain.Author;
import my.learn.bookstore.domain.Book;
import my.learn.bookstore.domain.Publisher;
import my.learn.bookstore.repository.AuthorRepository;
import my.learn.bookstore.repository.BookRepository;
import my.learn.bookstore.repository.PublisherRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;

public class StartupRunner implements CommandLineRunner {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private BookRepository bookRepository;

    @Autowired private AuthorRepository authorRepository;
    @Autowired private PublisherRepository publisherRepository;

    public void run(String... args) throws Exception {
        populateWithData();
        logger.info("Number of books: " + bookRepository.count());
    }

    private void populateWithData() {
        Author author = Author.builder().firstName("Alex").lastName("Antonov").build();
        author = authorRepository.save(author);
        Publisher publisher = Publisher.builder().name("Packt").build();
        publisher = publisherRepository.save(publisher);
        Book book = Book.builder().isbn("978-1-78528-415-1").title("Spring Boot Recipes").author(author).publisher(publisher).build();
        bookRepository.save(book);
    }

    @Scheduled(initialDelay = 1000, fixedRate = 10000)
    public void runScheduled() {
        logger.info("Number of books: " + bookRepository.count());
    }
}