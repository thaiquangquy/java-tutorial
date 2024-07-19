package Set;

import java.util.*;

public class NavigableSetExample {
    // Behaves like a SortedSet plus navigation methods
    // e.g: Navigate in reserve order

    public static void initializeSet() {
        NavigableSet<Integer> acsSortedSet = new TreeSet<Integer>();
        acsSortedSet.add(100);
        acsSortedSet.add(200);
        acsSortedSet.add(300);
        acsSortedSet.add(400);
        acsSortedSet.add(500);
        System.out.println(acsSortedSet);
        System.out.println("descendingSet: " + acsSortedSet.descendingSet());

        Comparator<Integer> desComparator = Comparator.reverseOrder();
        NavigableSet<Integer> desSortedSet = new TreeSet<>(desComparator);
        desSortedSet.addAll(acsSortedSet);

        System.out.println("desSortedSet: " + desSortedSet);

        System.out.println("First: " + desSortedSet.first());
        System.out.println("Last: " + desSortedSet.last());
        System.out.println("ceiling 205: " + desSortedSet.ceiling(205));
        System.out.println("floor 205: " + desSortedSet.floor(205));
        System.out.println("lower 205: " + desSortedSet.lower(205));
        System.out.println("higher 205: " + desSortedSet.higher(205));
        System.out.println("contains 205: " + desSortedSet.contains(205));
        System.out.println("descendingSet: " + desSortedSet.descendingSet());
        System.out.println("headSet: " + desSortedSet.headSet(200));
        System.out.println("tailSet: " + desSortedSet.tailSet(200));
        System.out.println("spliterator: ");
        Spliterator<Integer> spliterator = desSortedSet.spliterator();
        spliterator.forEachRemaining(System.out::println);
        System.out.println("desIterator: ");
        Iterator<Integer> desIterator = desSortedSet.descendingIterator();
        while (desIterator.hasNext()) {
            System.out.println(desIterator.next());
        }
        System.out.println("max: " + desSortedSet.stream().max(Comparator.naturalOrder()));
        System.out.println("min: " + desSortedSet.stream().min(Comparator.naturalOrder()));
        System.out.println("map to float: " + desSortedSet.stream().map(Integer::floatValue).toList());
        System.out.println("pollFirst: " + desSortedSet.pollFirst());
        System.out.println("pollLast: " + desSortedSet.pollLast());
        System.out.println(desSortedSet);

    }

    // TODO: provide example with custom object
    public static void initializeObjectSet() {
    }

    public static void main(String[] args) {
        initializeSet();
    }
}
