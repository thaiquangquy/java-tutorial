import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TransactionRequiredException;
import org.example.persistence_context.ExtendedPersistenceContextUserService;
import org.example.persistence_context.TransctionPersistenceContextUserService;
import org.example.persistence_context.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = org.example.Main.class)
public class PersistenceContextIntegrationTest {
    @Autowired
    private ExtendedPersistenceContextUserService extendedPersistenceContextUserService;
    @Autowired
    private TransctionPersistenceContextUserService transctionPersistenceContextUserService;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Test
    public void givenExtendedPersistenceContext_whenInsertWithoutTransaction_thenNoInsert() {
        User user = new User();
        user.setName("John Doe");
        user.setRole("admin");
        extendedPersistenceContextUserService.insertWithoutTransaction(user);
        User userFromDB = extendedPersistenceContextUserService.find(user.getId());
        assertNull(userFromDB);
    }

    @Test(expected = TransactionRequiredException.class)
    public void testThatUserSaveWithoutTransactionThrowException() {
        User user = new User(122L, "Devender", "admin");
        transctionPersistenceContextUserService.insertWithoutTransaction(user);
    }
}