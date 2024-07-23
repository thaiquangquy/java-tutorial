package org.example.dependency_injection;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyService4 {
    private final MyRepository myRepository;

    // Business methods
    public void print() {
        myRepository.print();
    }
}
