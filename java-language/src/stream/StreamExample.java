package stream;

import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
//        question1();
        question2();
    }

    private static void question1() {
        var list = List.of(1, 2, 3, 4, 5, 6).stream()
                .filter(it -> it % 2 == 0)
                .map(it -> it * it)
                .collect(Collectors.toList());
        System.out.println(list);
    }

    private static void question2() {
        var result = List.of(1, 2, 3, 4, 5, 6).stream()
                .filter(it -> {
                    System.out.println("testing: " + it);
                    return it % 2 == 0;
                })
                .map(it -> {
                    System.out.println("mapping: " + it);
                    return it * it;
                })
                .findFirst().get();
        System.out.println(result);

    }
}
