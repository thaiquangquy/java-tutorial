package org.example.hibernate.original;

import jakarta.persistence.Entity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class HibernateLongRunning {
    public int getCalculated() {
        System.out.println("Calculating");
        var data = getData();
        System.out.println("Retrieved");
        var result = calculate(data);
        System.out.println("Calculated");
        return result;
    }

    private List<Model> getData() {
        // retrieving a lot of records
        return null;
    }

    private int calculate(List<Model> data) {
        // calculating some value based on data;
        // Pure function, contains only simple calculations; Does not call any DAO functions explicitly
        return 0;
    }
}
