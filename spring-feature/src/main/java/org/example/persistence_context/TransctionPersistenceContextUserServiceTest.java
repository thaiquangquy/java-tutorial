package org.example.persistence_context;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class TransctionPersistenceContextUserServiceTest {

    @Mock
    private EntityManager entityManager;

    @InjectMocks
    private TransctionPersistenceContextUserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void insertWithTransaction_persistsAndReturnsUser() {
        User user = new User();
        User persistedUser = userService.insertWithTransaction(user);
        verify(entityManager, times(1)).persist(user);
        assertEquals(user, persistedUser);
    }

    @Test
    void insertWithoutTransaction_persistsAndReturnsUser() {
        User user = new User();
        User persistedUser = userService.insertWithoutTransaction(user);
        verify(entityManager, times(1)).persist(user);
        assertEquals(user, persistedUser);
    }

    @Test
    void find_returnsUserWhenExists() {
        User user = new User();
        when(entityManager.find(User.class, 1L)).thenReturn(user);
        User foundUser = userService.find(1L);
        assertEquals(user, foundUser);
    }

    @Test
    void find_returnsNullWhenUserDoesNotExist() {
        when(entityManager.find(User.class, 1L)).thenReturn(null);
        User foundUser = userService.find(1L);
        assertNull(foundUser);
    }
}