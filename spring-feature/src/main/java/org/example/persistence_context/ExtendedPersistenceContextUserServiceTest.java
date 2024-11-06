package org.example.persistence_context;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ExtendedPersistenceContextUserServiceTest {

    @Mock
    private EntityManager entityManager;

    @Autowired
    private ExtendedPersistenceContextUserService extendedPersistenceContextUserService;

    @InjectMocks
    private TransctionPersistenceContextUserService transctionPersistenceContextUserService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void insertWithTransaction_persistsUser() {
        User user = new User(1, "John Doe", "admin");
        extendedPersistenceContextUserService.insertWithTransaction(user);
        User userFromTransctionPersistenceContext = transctionPersistenceContextUserService
                .find(user.getId());
        assertNotNull(userFromTransctionPersistenceContext);

        User userFromExtendedPersistenceContext = extendedPersistenceContextUserService
                .find(user.getId());
        assertNotNull(userFromExtendedPersistenceContext);
//        verify(entityManager, times(1)).persist(user);
    }

    @Test
    void insertWithoutTransaction_persistsUser() {
        User user = new User();
        extendedPersistenceContextUserService.insertWithoutTransaction(user);
        verify(entityManager, times(1)).persist(user);
    }

    @Test
    void find_returnsUser() {
        User user = new User();
        when(entityManager.find(User.class, 1L)).thenReturn(user);
        User foundUser = extendedPersistenceContextUserService.find(1L);
        assertEquals(user, foundUser);
    }

    @Test
    void find_returnsNullWhenUserNotFound() {
        when(entityManager.find(User.class, 1L)).thenReturn(null);
        User foundUser = extendedPersistenceContextUserService.find(1L);
        assertNull(foundUser);
    }
}