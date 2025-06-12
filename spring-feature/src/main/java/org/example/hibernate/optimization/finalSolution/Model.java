package org.example.hibernate.optimization.finalSolution;


import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

// OPTIMIZED ENTITY: Immutable + Minimal fields
@Entity
@Table(name = "model", indexes = {
        @Index(name = "idx_model_active", columnList = "active"),
        @Index(name = "idx_model_category", columnList = "category")
})
@Immutable
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value", nullable = false)
    private Integer value;

    @Column(name = "category")
    private String category;

    @Column(name = "active", nullable = false)
    private Boolean active;

    // Getters
    public Long getId() { return id; }
    public Integer getValue() { return value != null ? value : 0; }
    public String getCategory() { return category; }
    public Boolean isActive() { return active != null ? active : false; }

    // Setters for Hibernate
    public void setId(Long id) { this.id = id; }
    public void setValue(Integer value) { this.value = value; }
    public void setCategory(String category) { this.category = category; }
    public void setActive(Boolean active) { this.active = active; }
}
