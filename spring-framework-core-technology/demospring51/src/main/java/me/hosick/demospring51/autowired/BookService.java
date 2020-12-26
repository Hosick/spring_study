package me.hosick.demospring51.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class BookService {

    /* 필드로 Bean 주입 */
    /*@Autowired*/
    BookRepository bookRepository;

    /* 생성자로 Bean 주입 */
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /* 설정자로 Bean 주입 */
    //@Autowired
    //@Qualifier("yourBookRepository") // Qualifier는 생성자에서 사용 할 수 없음
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /* 주입받은 Repository 클래스 출력 */
    /* 라이프 사이클 인터페이스 사용 */
    @PostConstruct
    public void printBookRepository(){
        System.out.println(bookRepository.getClass());
    }
}