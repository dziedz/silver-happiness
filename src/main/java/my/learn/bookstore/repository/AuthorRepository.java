package my.learn.bookstore.repository;

import my.learn.bookstore.domain.Author;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AuthorRepository extends
        PagingAndSortingRepository<Author, Long> {
}