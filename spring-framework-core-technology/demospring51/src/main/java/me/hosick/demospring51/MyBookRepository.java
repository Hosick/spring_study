package me.hosick.demospring51;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
/*@Primary*/
public class MyBookRepository implements BookRepository{
}
