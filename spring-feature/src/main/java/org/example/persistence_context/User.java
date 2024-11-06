package org.example.persistence_context;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    long id;
    String name;
    String role;
}
