package Set;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

enum Size {
    SMALL,
    MEDIUM,
    LARGE,
    EXTRALARGE,
}

public class EnumSetExample {
    // High-performance set implementation, much faster than HashSet
    // all elements must come from a single enumeration type explicitly or implicitly
    // doesn't allow null object and throw NullPointerException if we do so
    // fail-save iterator, won't throw ConcurrentModificationException when collection is modified when iterating
    // internally implement as a sequence of bits
    public static void initializeEnumSet() {
        List<Size> list = Arrays.asList(Size.LARGE, Size.EXTRALARGE);

        // construct with enum values
        Set<Size> sizes = EnumSet.allOf(Size.class);
        System.out.println("sizes: " + sizes);

        EnumSet<Size> sizes1 = EnumSet.of(Size.SMALL, Size.MEDIUM);
        System.out.println("sizes1: " + sizes1);

        EnumSet<Size> sizes2 = EnumSet.range(Size.MEDIUM, Size.EXTRALARGE);
        System.out.println("sizes2: " + sizes2);

        var size3 = EnumSet.noneOf(Size.class);
        System.out.println("sizes3: " + size3);
        // constructure with list
        size3.addAll(list);
        System.out.println("sizes3: " + size3);

        System.out.println(sizes.containsAll(sizes1));
        System.out.println(sizes2.remove(Size.SMALL));
        System.out.println("sizes2: " + sizes2);
        System.out.println(sizes2.removeIf(size -> size.ordinal() > Size.LARGE.ordinal()));
        System.out.println("sizes2: " + sizes2);
        sizes2.clear();
        System.out.println("sizes2: " + sizes2);

        var iterator = sizes2.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ",");
        }

        System.out.println();
        for (var size : sizes1) {
            System.out.print(size + " ");
        }
    }

    public static void main(String[] args) {
        initializeEnumSet();
    }
}
