package my.learn.bookstore.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dziedz on 25/08/16.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String isbn;
    private String title;
    private String description;

    @ManyToOne
    private Author author;
    @ManyToOne
    private Publisher publisher;

    @ManyToMany
    private List<Reviewer> reviewers;

}