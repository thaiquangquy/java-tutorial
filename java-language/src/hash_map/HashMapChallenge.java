package hash_map;

import java.util.*;

public class HashMapChallenge {
    void main() {
        //        challenge_1();
        challenge_2();
        //        challenge_3();
    }

    // Challenge 1.
    // Make a Library class. It should have four exposed methods
    // 1. add which takes a Book and adds it to the library.
    // 2. list which returns an ArrayList<String> of all the Books in the library. The Strings in this list should be
    // the ISBN of the book.
    // 3. find which takes a String representing the ISBN and returns a full Book record.
    // 4. remove which takes a String representing the ISBN and removes that Book from the library.
    // Use a HashMap for storing this info in the Library.

    record Book(String isbn, String title, String author) {}

    class Library {
        // CODE HERE
        Map<String, Book> books = new HashMap<>();

        public void add(Book book) {
            if (book.isbn == null) {
                throw new IllegalArgumentException("isbn must not be null");
            }

            books.put(book.isbn, book);
        }

        public ArrayList<String> list() {
            ArrayList<String> bookArray = new ArrayList<>();
            //            return books.values().stream().map(book -> book.isbn).toArray();
            books.values().forEach(book -> bookArray.add(book.isbn));
            return bookArray;
        }

        public Book find(String isbn) {
            return books.getOrDefault(isbn, null);
        }

        public void remove(String isbn) {
            books.remove(isbn);
        }
    }

    private void challenge_1() {
        Library publicLibrary = new Library();
        publicLibrary.add(new Book("978-0-8041-3902-1", "The Martian", "Andy Weir"));
        publicLibrary.add(new Book("978-0062060624", "The Song of Achilles", "Madeline Miller"));

        IO.println(publicLibrary.list());

        Book b1 = publicLibrary.find("978-0062060624");
        IO.println(b1); // The Song of Achilles

        Book b2 = publicLibrary.find("123");
        IO.println(b2); // null

        publicLibrary.remove("978-0062060624");

        Book b3 = publicLibrary.find("978-0062060624");
        IO.println(b3); // null

        IO.println(publicLibrary.list());
    }

    // Challenge 2.
    // Write a method which takes as an argument an ArrayList<String> and returns a HashMap<String, Integer> where each
    // key is a String from the original ArrayList and each value is the number of times it appeared in that ArrayList.

    HashMap<String, Integer> count(ArrayList<String> words) {
        // CODE HERE
        HashMap<String, Integer> countMap = new HashMap<>();
        for (var word : words) {
//            countMap.compute(word, (k, v) -> v == null ? 1 : v + 1);
            // line above or another version using merge
            countMap.merge(word, 1, Integer::sum);
        }
        return countMap;
    }

    private void challenge_2() {
        ArrayList<String> w = new ArrayList<>();
        w.add("duck");
        w.add("duck");
        w.add("duck");
        w.add("goose");
        w.add("duck");
        w.add("duck");
        w.add("duck");
        w.add("duck");
        w.add("duck");
        w.add("duck");
        w.add("duck");
        w.add("duck");
        w.add("goose");
        w.add("zebra");

        // {duck=11,goose=2,zebra=1}
        IO.println(count(w));
    }

    // Challenge 3.
    // Without calling any methods on the HashMap, make it so that map.get(person) returns null.
    class Person {
        int age;

        Person(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person[age=" + age + "]";
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Person p) {
                return age == p.age;
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            return Objects.hash(age);
        }
    }

    private void challenge_3() {
        var person = new Person(22);
        var map = new HashMap<Person, String>();
        map.put(person, "Achilles");

        // -------------

        // CODE HERE
        // Do not directly touch "map"
        person.age = 20;
        // -------------

        // Should output `null`
        IO.println(map.get(person));
    }
}
