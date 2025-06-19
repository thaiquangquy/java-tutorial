## Java Happens-Before Guarantee

| Rule                    | What It Ensures                                                                 | Code Snippet                                                                                                | Guarantee                                                                                   |
|-------------------------|----------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------|
| **Volatile Write**      | All normal writes before a volatile write happen-before that volatile write.    | ```frame = newFrame;count++;hasNewFrame = true; // volatile```                                       | `frame` and `count` values are flushed before `hasNewFrame = true`                         |
| **Volatile Read**       | A volatile read happens-before all subsequent reads/writes in the same thread. | ```while (!hasNewFrame); // volatile readFrame f = frame;long c = count;```                    | `frame` and `count` will see the most up-to-date values                                    |
| **Synchronized Entry**  | Entering `synchronized` block reads latest values from main memory.             | ```synchronized (this) {    c = valC;}a = valA;b = valB;```                                | `valA`, `valB` and `valC` will be refreshed from main memory                               |
| **Synchronized Exit**   | Exiting `synchronized` block flushes all changes to main memory.                | ```valA = v.a;valB = v.b;synchronized (this) {    valC = v.c;} // synchronized exit```     | `valA`, `valB`, and `valC` are flushed to main memory after block                          |

- Volatile write guarantee forces all preceding writes to become visible before another thread sees the volatile change.

- Volatile read guarantee ensures everything after the volatile-read sees fully up-to-date values.

- Synchronized entry/exit ensure mutual visibility and ordering around critical sections.


[1]: https://jenkov.com/tutorials/java-concurrency/java-happens-before-guarantee.html?utm_source=chatgpt.com "Java Happens Before Guarantee - Jenkov.com"
