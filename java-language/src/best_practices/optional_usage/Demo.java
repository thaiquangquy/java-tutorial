package best_practices.optional_usage;

import java.util.List;
import java.util.Optional;

public class Demo {
    public static void main(String[] args) {
        List<User> users = List.of(new User("alice", "alice@example.com"), new User("bob", null));

        printEmailTheBadWay(users, "bob");   // works by luck, one branch away from an NPE
        printEmailTheGoodWay(users, "bob");  // caller is forced to handle the missing case
        printEmailTheGoodWay(users, "carol"); // no user found at all
    }

    // Anti-pattern: returning null forces every caller to remember a null
    // check. Forget one, and it blows up far from where the null originated.
    private static String findEmailOrNull(List<User> users, String name) {
        for (User user : users) {
            if (user.name().equals(name)) {
                return user.email(); // may itself be null
            }
        }
        return null;
    }

    private static void printEmailTheBadWay(List<User> users, String name) {
        String email = findEmailOrNull(users, name);
        if (email != null) {
            System.out.println(name + "'s email: " + email);
        } else {
            System.out.println(name + " has no email on file (bad-way check).");
        }
    }

    // Preferred: Optional makes "might be absent" part of the method
    // signature, and the fluent API keeps handling both cases concise.
    private static Optional<String> findEmail(List<User> users, String name) {
        return users.stream()
                .filter(user -> user.name().equals(name))
                .findFirst()
                .flatMap(user -> Optional.ofNullable(user.email()));
    }

    private static void printEmailTheGoodWay(List<User> users, String name) {
        String message = findEmail(users, name)
                .map(email -> name + "'s email: " + email)
                .orElse(name + " has no email on file (good-way check).");
        System.out.println(message);
    }

    private record User(String name, String email) {
    }
}
