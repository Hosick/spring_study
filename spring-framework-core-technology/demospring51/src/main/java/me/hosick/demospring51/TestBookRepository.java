package me.hosick.demospring51;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
/*@Profile("test")*/
@Profile("!prod")
public class TestBookRepository implements BookRepository {
}
