package study;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayDeque;
import java.util.Queue;

import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    void shouldRunWithoutError() {
        Queue<String> q = new ArrayDeque<>();

        q.add("a");
        
        final String poll = q.poll();

        assertEquals("a", poll);
        assertEquals(0, q.size());
    }

}
