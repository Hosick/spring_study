package springbook.user.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springbook.user.domain.User;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "/test-applicationContext.xml")
public class UserDaoTest {

  private UserDao dao;

  private User user1;
  private User user2;
  private User user3;

  @Before
  public void setUp() {
    // System.out.println(this.context);
    // System.out.println(this);

    user1 = new User("gyumee", "박성철", "springno1");
    user2 = new User("leegw700", "이길원", "springno2");
    user3 = new User("bumjin", "박범진", "springno3");

    dao = new UserDao();
    DataSource dataSource =
        new SingleConnectionDataSource("jdbc:mysql://localhost/testdb?serverTimezone=UTC", "spring",
            "book", true);
    dao.setDataSource(dataSource);
  }

  @Test
  public void addAndGet() throws SQLException {
    dao.deleteAll();
    assertThat(dao.getCount(), is(0));

    dao.add(user1);
    assertThat(dao.getCount(), is(1));

    User newUser = dao.get(user1.getId());

    assertThat(newUser.getName(), is(user1.getName()));
    assertThat(newUser.getPassword(), is(user1.getPassword()));
  }

  @Test
  public void count() throws SQLException {
    dao.deleteAll();
    assertThat(dao.getCount(), is(0));

    dao.add(user1);
    assertThat(dao.getCount(), is(1));

    dao.add(user2);
    assertThat(dao.getCount(), is(2));

    dao.add(user3);
    assertThat(dao.getCount(), is(3));
  }

  @Test(expected = EmptyResultDataAccessException.class)
  public void getUserFailure() throws SQLException {
    dao.deleteAll();
    assertThat(dao.getCount(), is(0));

    dao.get("unknown_id");
  }
}