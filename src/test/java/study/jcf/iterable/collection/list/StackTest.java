package study.jcf.iterable.collection.list;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Stack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StackTest {

  @Test
  @DisplayName("Stack 은 후입선출(LIFO; Last-In First-Out) 이네요.")
  void test() {
    final Stack<String> strings = new Stack<>();
    strings.push("test");

    assertEquals(1, strings.size());

    strings.push("hi");
    strings.push("hello");
    strings.push("nihao");

    assertEquals(2, strings.search("hello"));

    assertEquals("nihao", strings.pop());
    assertEquals("hello", strings.peek());
    assertEquals("hello", strings.pop());
    assertEquals("hi", strings.pop());
  }

}
