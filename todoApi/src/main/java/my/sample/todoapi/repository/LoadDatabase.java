package my.sample.todoapi.repository;

import my.sample.todoapi.dto.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    public CommandLineRunner initDatabase(TodoRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Todo("wahhh","Take over the galaxy")));
            log.info("Preloading " + repository.save(new Todo("destroy alderaan","Make sure there are no survivors left!")));
        };
    }
}