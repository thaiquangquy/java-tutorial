package arrays;

import java.util.ArrayList;
import java.util.Locale;
import java.util.stream.Collectors;

public class Challenge {
    static void main() {
//        challenge_2();
//        challenge_3();
        challenge_4();
    }

    // Capitalize every String in the ArrayList<String>.
    private static void challenge_2() {
        ArrayList<String> things = new ArrayList<>();
        things.add("movies");
        things.add("television");
        things.add("video games");

        // CODE HERE
        things.replaceAll(s -> s.toUpperCase(Locale.ROOT));

        // Should output
        // [MOVIES, TELEVISION, VIDEO GAMES]
        IO.println(things);
    }


    // Challenge 3.
    //Every time John Wick assassinates someone he gets one crime coin (to spend at a crime hotel).
    //Watch the first John Wick movie. For each named character you can remember John Wick assassinating add one crime coin to the johnWick ArrayList.
    record CrimeCoin(String target) {}
    static ArrayList<CrimeCoin> challenge_3() {
        ArrayList<CrimeCoin> johnWick = new ArrayList<>();

        // CODE HERE
        johnWick.add(new CrimeCoin("A"));
        johnWick.add(new CrimeCoin("B"));
        johnWick.add(new CrimeCoin("C"));

        IO.println(johnWick);
        return johnWick;
    }

    // Challenge 4.
    // Using the ArrayList of CrimeCoins, construct an ArrayList<String> with all the characters' names.
    private static void challenge_4() {
        ArrayList<CrimeCoin> johnWick = new ArrayList<>();

        // CODE FROM LAST CHALLENGE
        johnWick = challenge_3();

        ArrayList<String> names = new ArrayList<>();

        // CODE HERE
        johnWick.forEach(c -> names.add(c.target));

        IO.println(names);
    }
}
