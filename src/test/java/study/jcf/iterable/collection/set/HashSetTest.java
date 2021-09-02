package study.jcf.iterable.collection.set;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

class HashSetTest {

    @Test
    @DisplayName("add, size, isEmpty, contains 메소드 / remove clear 차이")
    void test() {
        HashSet hashSet = new HashSet();

        hashSet.add(1);
        hashSet.add("1");
        hashSet.add(2);
        hashSet.add("2");

        assertEquals(4, hashSet.size());
        assertEquals(false, hashSet.isEmpty());
        assertEquals(true, hashSet.contains("2"));
        assertEquals(false, hashSet.contains("3"));

        hashSet.remove(2);
        assertEquals(3, hashSet.size());

        hashSet.clear();
        assertEquals(0, hashSet.size());
    }

    @Test
    @DisplayName("똑같은 값을 clone하여 add하기")
    void test2() {
        HashSet hashSet = new HashSet();

        hashSet.add(1);
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(4);

        assertEquals(4, hashSet.size());

        hashSet.addAll((HashSet) hashSet.clone());

        assertEquals(4, hashSet.size());

    }
}
