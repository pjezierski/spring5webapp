package guru.springframework.spring5webapp.repository;

import guru.springframework.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository dla autorów.
 *
 * @author pjezierski
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
