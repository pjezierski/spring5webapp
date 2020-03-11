package guru.springframework.spring5webapp.web;

import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api")
public class HelloWorldRestController {

    private PublisherRepository publisherRepository;

    public HelloWorldRestController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @GetMapping("helloWorld/{id}")
    public Publisher helloWorld(@PathVariable Long id) {
        Optional<Publisher> publisherOptional = publisherRepository.findById(id);
        return publisherOptional.orElse(null);
    }
}
