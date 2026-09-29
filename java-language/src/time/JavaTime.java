package time;

import java.time.*;
import java.util.Objects;

public class JavaTime {

    static void main(String[] args) {

        //        var fiveMinutes = Duration.ofMinutes(5);
        //        IO.println(fiveMinutes);
        //
        //        var twelveMilliSeconds = Duration.ofMillis(12);
        //        IO.println(twelveMilliSeconds);

        //        challenge_1();
        //        challenge_1_improve();
        //        challenge_2();
        //                challenge_3();
        challenge_4();
    }

    // Challenge 1
    // Print out every day from January 1st to December 31st.
    // When the program reaches your birthday make it print out "Happy Birthday <your name>" instead of the date.
    private static void challenge_1() {
        LocalDate startDate = LocalDate.of(2026, 1, 1);
        LocalDate endDate = LocalDate.of(2026, 12, 31).plusDays(1);

        while (startDate.isBefore(endDate)) {
            if (startDate.isEqual(LocalDate.of(2026, 8, 1))) {
                System.out.printf("Today is %s\n", startDate);
                System.out.println("Happy Birthday Quy");
            }
            startDate = startDate.plusDays(1);
        }
    }

    private static void challenge_1_improve() {
        var year = 2026;
        var birthDay = MonthDay.of(8, 1);
        LocalDate.of(year, 1, 1)
                .datesUntil(LocalDate.of(year + 1, 1, 1))
                .map(d -> MonthDay.from(d).equals(birthDay) ? "Happy birthday Quy" : d)
                .forEach(System.out::println);
    }

    // Make a Poison class which has a Duration field which stores how long the poison will be potent for as well as an
    // Instant at which the poison was brewed.
    // Implement a method that takes an Instant and returns if the Poison will be expired by that point.

    static class Poison {
        Instant brewedAt;
        Duration potency;
        Instant expiresAt;

        Poison(Instant brewedAt, Duration potency) {
            Objects.requireNonNull(brewedAt, "brewedAt");
            Objects.requireNonNull(potency, "potency");
            if (potency.isNegative()) {
                throw new IllegalArgumentException("potency must not be negative");
            }

            brewedAt = brewedAt;
            potency = potency;
            expiresAt = brewedAt.plus(potency);
        }

        public boolean isPotentAt(Instant time) {
            Objects.requireNonNull(time, "time");
            return time.isBefore(expiresAt);
        }
    }

    private static void challenge_2() {
        var hemlock = new Poison(Instant.now(), Duration.ofDays(365 * 3));

        IO.println(hemlock.isPotentAt(Instant.now())); // true
        IO.println(hemlock.isPotentAt(Instant.now().plus(Duration.ofDays(5)))); // true
        IO.println(hemlock.isPotentAt(Instant.now().plus(Duration.ofDays(365 * 10)))); // false
        hemlock.isPotentAt(null);
    }

    // Get as input using IO.readln a day, month, year, and UTC offset.
    // Interpret that input as an OffsetDateTime then print how many seconds will have passed between that offset date
    // time and midnight of January 1st 1983 GMT.
    private static final Instant EPOCH_1983 = Instant.parse("1983-01-01T00:00:00Z");

    private static void challenge_3() {
        var year = IO.readln("Enter year: ").strip();
        var month = IO.readln("Enter month: ").strip();
        var day = IO.readln("Enter day: ").strip();
        var offset = IO.readln("Enter UTC offset(e.g: +07:00): ").strip();

        var localDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
        var inputDate = localDate.atStartOfDay().atOffset(ZoneOffset.of(offset));
        IO.println(Duration.between(inputDate.toInstant(), EPOCH_1983).toSeconds());
    }

    // A train leaves Boston at 12:50pm EDT on August 23rd 2025 and arrives in Chicago at 10:12am CDT August 24th 2025.
    // How many minutes long was that train ride? Use the Java's time classes to figure out the answer.
    private static void challenge_4() {
        var leaveTime = ZonedDateTime.of(2025, 8, 23, 12, 50, 0, 0, ZoneId.of("America/New_York"));
        var arriveTime = ZonedDateTime.of(2025, 8, 24, 10, 12, 0, 0, ZoneId.of("America/Chicago"));

        var durationInMinute = Duration.between(leaveTime, arriveTime).toMinutes();
        IO.println(durationInMinute);
    }
}
