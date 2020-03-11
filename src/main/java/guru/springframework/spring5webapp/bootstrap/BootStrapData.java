package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Address;
import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Klasa startowa aplikacji.
 *
 * @author pjezierski
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private PublisherRepository publisherRepository;

    private AuthorRepository authorRepository;

    public BootStrapData(PublisherRepository publisherRepository, AuthorRepository authorRepository) {
        this.publisherRepository = publisherRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) {
        Address address = new Address("Polska", "nieznany", "85363");
        Publisher publisher = new Publisher("Piotr", address);

        publisherRepository.save(publisher);

        if(publisherRepository.count() == 1){
            System.out.println("publisher was saved");
            System.out.println(publisherRepository.findAll());
        }else {
            throw new RuntimeException("publisher save error");
        }

        Author author = new Author("Piotr", "Test");
        Author author1 = new Author("Adam", "Test1");
        Author author2 = new Author("Artur", "Test2");
        authorRepository.saveAll(Arrays.asList(author, author1, author2));
    }
}
