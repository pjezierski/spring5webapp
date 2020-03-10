package guru.springframework.spring5webapp.repository;

import guru.springframework.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Repo dla publikującego
 *
 * @author pjezierski
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
