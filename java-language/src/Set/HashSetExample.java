package Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
    public static void testHashSet() {
        Set<Integer> setOfNumber = new HashSet<>();
        setOfNumber.add(100);
        setOfNumber.add(200);
        setOfNumber.add(300);
        setOfNumber.add(400);
        setOfNumber.add(100);
        System.out.println(setOfNumber);

        setOfNumber.remove(100);
        setOfNumber.removeIf(integer -> integer <= 300);
        Iterator<Integer> setIterator = setOfNumber.iterator();
        while (setIterator.hasNext()) {
            System.out.print(setIterator.next() + ", ");
        }
        System.out.println();

        HashSet<Integer> setFoo = new HashSet<>();
        setFoo.add(100);
        setFoo.add(200);
        setFoo.add(300);
        setFoo.add(400);

        HashSet<Integer> setBar = new HashSet<>();
        setBar.add(100);
        setBar.add(200);
        setBar.add(500);
        setBar.add(600);

        // Union
        setFoo.addAll(setBar);
        System.out.println(setFoo);

        // Subset
        System.out.println(setFoo.contains(600));
        System.out.println(setFoo.contains(700));
        System.out.println(setFoo.containsAll(setBar));

        // Intersection
        setFoo.retainAll(setBar);
        System.out.println(setFoo);
    }

    public static void main(String[] arg) {
        testHashSet();
    }
}
