package my.learn.bookstore.repository;


import my.learn.bookstore.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    Book findBookByIsbn(String isbn);

    Book save(Book book);
}