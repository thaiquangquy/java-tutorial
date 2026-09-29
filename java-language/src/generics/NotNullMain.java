package generics;

import java.util.Objects;

// Make a class that holds a NotNull value. This class should be generic over the kind of data that it holds but it
// should throw an exception if the provided value is null.
public class NotNullMain {
    // CODE HERE
    static class NotNull<T> {
        T value;

        NotNull(T value) {
            this.value = Objects.requireNonNull(value, "value cannot be null");
            this.value = value;
        }
    }

    void main() {
        NotNull<String> s = new NotNull<>("abc");
        IO.println(s.value);

        NotNull<Integer> i = new NotNull<>(123);
        IO.println(i.value);

        // This should throw an exception
        NotNull<Double> d = new NotNull<>(null);
    }
}
