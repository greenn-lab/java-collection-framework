package study.jcf.iterable.collection.list;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

class LinkedListTest {

    @Test
    @DisplayName("LinkedList 데이터 가져오는 메소드들")
    void test() {
        LinkedList list = new LinkedList();

        list.add("1");
        list.addFirst("2");
        list.addLast("3");

        assertEquals("2", list.getFirst());
        assertEquals("2", list.peek());
        assertEquals("2", list.poll());
        assertEquals("3", list.getLast());
        assertEquals("1", list.pollFirst()); // unlinkedFirst
        assertEquals("3", list.pollLast()); // unlinkedLast
        assertEquals(0, list.size());
    }

    @Test
    @DisplayName("push, offer, poll, remove, clear 메소드 차이")
    void test2() {
        LinkedList list = new LinkedList();

        list.push(1);
        list.offerFirst(2);
        list.offerLast(3);
        list.offer(4);
        list.offer(5);
        list.poll();
        list.remove();

        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));

        list.clear();

        System.out.println("======");

        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));

        assertEquals(false, list.contains(2));
    }

    @Test
    @DisplayName("offer, add, push 시 들어가는 순서와 remove와 removeFirstOccurrence 차이")
    void test3() {
        LinkedList list = new LinkedList();

        list.offer(1);
        list.add(2);
        list.push(3);
        list.push(4);

        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));

        System.out.println("==========");

        assertEquals(true, list.removeFirstOccurrence(2));
        assertEquals(true, list.removeLastOccurrence(3));
        assertEquals(2, list.size());

        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));

        assertEquals(1, list.remove(1));

        assertEquals(4, list.get(0));

    }

    @Test
    @DisplayName("LinkedList clone")
    void test4() {
        LinkedList list = new LinkedList();

        list.add(1);
        list.add(2);
        list.add(3);

        list.addAll((LinkedList) list.clone());

        assertEquals(6, list.size());

    }

    @Test
    @DisplayName("pop과 poll의 차이1")
    void test5() {
        LinkedList list = new LinkedList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));

        assertEquals(1, list.pop());
        assertEquals(2, list.poll());

        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }

    @Test
    @DisplayName("pop과 poll의 차이2")
    void test6(){
        LinkedList list = new LinkedList();

        assertEquals(null, list.poll()); // true
        assertEquals(null, list.pop()); // NoSuchElementException
    }
}
