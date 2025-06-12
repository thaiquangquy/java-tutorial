package org.example.hibernate.optimization.original.original;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "model")
public class Model {
    @Id
    @GeneratedValue
    Long id;
}
