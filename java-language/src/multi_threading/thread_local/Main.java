package multi_threading.thread_local;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                int threadId = Integer.parseInt(Arrays.stream(Thread.currentThread().getName().splitWithDelimiters("-", 2)).toList().getLast());
                if (threadId % 2 == 0) {
                    System.out.println("Thread: " + Thread.currentThread().getName() + " date: " + DateUtils.formatDate(Date.from(Instant.ofEpochSecond(10000L))));
                } else {
                    DateUtils.setDateFormat("yyyy-mm-dd");
                    System.out.println("Thread: " + Thread.currentThread().getName() + " new date format: " + DateUtils.formatDate(Date.from(Instant.ofEpochSecond(10000L))));
                }
            });
            t.start();
        }
    }
}
