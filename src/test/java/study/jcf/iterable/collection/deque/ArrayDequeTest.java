package study.jcf.iterable.collection.deque;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayDeque;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;

class ArrayDequeTest {

  @Test
  void test() {
    final ArrayDeque<String> strings = new ArrayDeque<>();

    strings.add("A");
    strings.add("B");
    strings.add("C");

    assertEquals(3, strings.size());
  }

  @Test
  void test2() {
    final ArrayDeque<String> strings = new ArrayDeque<>();

    strings.add("A");
    strings.add("B");
    strings.add("C");
    strings.add("D");
    strings.add("E");

    assertEquals("A", strings.peek());
    assertEquals("A", strings.pollFirst());
    assertEquals("E", strings.pollLast());
    assertEquals("B", strings.poll());
    assertEquals("C", strings.peek());
    assertEquals("C", strings.getFirst());
    assertEquals("D", strings.getLast());
  }

  public static void main(final String... args) {
    final LinkedBlockingDeque<String> strings = new LinkedBlockingDeque<>();

    final Thread thread = new Thread(() -> {
      try {
        final String take = strings.take();

        System.out.println("take: " + take);

      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    thread.start();

    new Thread(() -> {
      try {

        TimeUnit.SECONDS.sleep(2);
        strings.add("hello");

      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }).start();

  }

}
