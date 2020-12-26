package me.hosick.demospring51.environment.profile;

import me.hosick.demospring51.autowired.BookRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("!prod")
public class TestBookRepository implements BookRepository {
}