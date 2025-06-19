package multi_threading.c02.virtual_thread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class VirtualThreadExample2LoadTest {
    public static void main(String[] args) {
        int numberOfThreads = 100_000;
//        List<Thread> vThreads = new ArrayList<>(); // This may not thread-safe
        List<Thread> vThreads = Collections.synchronizedList(new ArrayList<>());
        Thread.Builder.OfVirtual builder = Thread.ofVirtual().name("Thread-", 0);

        for (int i = 0; i < numberOfThreads; i++) {
//            int finalI = i;
            Thread vThread = builder.start(() -> {
//                if (finalI == 99_999) {
//                    System.out.println("I am the last item!: " + finalI);
//                }
                int result = 1;
                for (int j = 0; j < 10; j++) {
                    result *= (j + 1);
                }
                System.out.println(Thread.currentThread().getName() + " resut: " + result);
            });
            vThreads.add(vThread);
        }

        for (Thread vThread : vThreads) {
            try {
                vThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
