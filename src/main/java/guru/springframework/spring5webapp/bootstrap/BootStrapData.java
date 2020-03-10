package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Address;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Klasa startowa aplikacji.
 *
 * @author pjezierski
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private PublisherRepository publisherRepository;

    public BootStrapData(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
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
    }
}
