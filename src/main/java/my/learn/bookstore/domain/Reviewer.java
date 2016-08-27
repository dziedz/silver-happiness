package my.learn.bookstore.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reviewer {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
}