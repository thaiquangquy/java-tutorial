package design_patterns.behavioral.iterator;

import design_patterns.behavioral.iterator.profile.Profile;
import design_patterns.behavioral.iterator.social_networks.Facebook;
import design_patterns.behavioral.iterator.social_networks.LinkedIn;
import design_patterns.behavioral.iterator.social_networks.SocialNetwork;
import design_patterns.behavioral.iterator.spammer.SocialSpammer;

import java.util.List;
import java.util.Scanner;

public class Demo {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Please specify social network to target spam tool (default:Facebook):");
        System.out.println("1. Facebook");
        System.out.println("2. LinkedIn");
        String choice = scanner.nextLine();

        SocialNetwork network;
        if (choice.equals("2")) {
            network = new LinkedIn(createTestProfiles());
        } else {
            network = new Facebook(createTestProfiles());
        }

        SocialSpammer socialSpammer = new SocialSpammer(network);
        socialSpammer.sendSpamToFriends("anna.smith@bing.com",
                "Hey! This is Anna's friend Josh. Can you do me a favor and like this post [link]?");
        socialSpammer.sendSpamToCoworkers("anna.smith@bing.com",
                "Hey! This is Anna's boss Jason. Anna told me you would be interested in [link].");
    }

    private static List<Profile> createTestProfiles() {
        return List.of(
                new Profile("anna.smith@bing.com", "Anna Smith", "friends:mad_max@ya.com", "friends:catwoman@yahoo.com", "coworkers:sam@amazon.com"),
                new Profile("mad_max@ya.com", "Maximilian", "friends:anna.smith@bing.com", "coworkers:sam@amazon.com"),
                new Profile("bill@microsoft.eu", "Billie", "coworkers:avanger@ukr.net"),
                new Profile("avanger@ukr.net", "John Day", "coworkers:bill@microsoft.eu"),
                new Profile("sam@amazon.com", "Sam Kitting", "coworkers:anna.smith@bing.com", "coworkers:mad_max@ya.com",
                        "friends:catwoman@yahoo.com"),
                new Profile("catwoman@yahoo.com", "Liza", "friends:anna.smith@bing.com", "friends:sam@amazon.com"));
    }
}
