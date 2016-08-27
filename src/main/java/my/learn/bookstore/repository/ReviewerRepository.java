package my.learn.bookstore.repository;

import my.learn.bookstore.domain.Reviewer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ReviewerRepository extends
        PagingAndSortingRepository<Reviewer, Long> {
}