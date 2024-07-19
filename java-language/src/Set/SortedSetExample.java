package Set;

import java.util.*;

public class SortedSetExample {
    // SortedSet implement the Mathematics set
    // Store all the elements in a sorted manner
    // Elements are ordered by either natural ordering or using Comparator
    // internal implemented by TreeSet use self-balancing tree

    public static void initializeSet() {
        SortedSet<String> acsSortedSet = new TreeSet<String>();
        acsSortedSet.add("Vietnam");
        acsSortedSet.add("America");
        acsSortedSet.add("India");
        acsSortedSet.add("China");
        acsSortedSet.add("Germany");
        System.out.println(acsSortedSet);
        System.out.println("acsSortedSet reverse order: " + acsSortedSet.stream().sorted().toList());

        Comparator<String> desComparator = Comparator.reverseOrder();
        SortedSet<String> desSortedSet = new TreeSet<>(desComparator);
        desSortedSet.addAll(acsSortedSet);
        System.out.println("desSortedSet: " + desSortedSet);

        System.out.println("First: " + desSortedSet.first());
        System.out.println("Last: " + desSortedSet.last());
        System.out.println("contains: " + desSortedSet.contains("G"));
        System.out.println("headSet: " + desSortedSet.headSet("G"));
        System.out.println("tailSet: " + desSortedSet.tailSet("G"));
        System.out.println("spliterator: ");
        Spliterator<String> spliterator = desSortedSet.spliterator();
        spliterator.forEachRemaining(System.out::println);
        System.out.println("max: " + desSortedSet.stream().max(Comparator.naturalOrder()));
        System.out.println("min: " + desSortedSet.stream().min(Comparator.naturalOrder()));
        System.out.println("peek: ");
        System.out.println(desSortedSet.stream().peek(System.out::println).toList());

    }

    // TODO: provide example with custom object
    public static void initializeObjectSet() {
    }

    public static void main(String[] args) {
        initializeSet();
    }
}
