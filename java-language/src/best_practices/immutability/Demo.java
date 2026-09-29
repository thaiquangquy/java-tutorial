package best_practices.immutability;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<String> tags = new ArrayList<>(List.of("origin"));
        ImmutablePoint point = new ImmutablePoint(0, 0, tags);

        // Mutating the original list after construction does NOT affect the
        // point, because the constructor took a defensive copy.
        tags.add("hacked");
        System.out.println("Point after external mutation: " + point);

        // "Changing" the point returns a brand new instance instead of
        // mutating the existing one.
        ImmutablePoint moved = point.withX(10);
        System.out.println("Original point: " + point);
        System.out.println("Moved point:    " + moved);

        try {
            point.getTags().add("cannot do this");
        } catch (UnsupportedOperationException e) {
            System.out.println("Tags list is unmodifiable, as expected: " + e.getClass().getSimpleName());
        }
    }
}
