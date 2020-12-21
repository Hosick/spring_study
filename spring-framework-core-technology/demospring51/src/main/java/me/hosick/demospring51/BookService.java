package me.hosick.demospring51;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired @Qualifier("myBookRepository")
    BookRepository bookRepository;

    /*@Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }*/

/*    @Autowired*//*(required = false)*//*
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }*/

    public void printBookRepository(){
        System.out.println(bookRepository.getClass());
    }
}