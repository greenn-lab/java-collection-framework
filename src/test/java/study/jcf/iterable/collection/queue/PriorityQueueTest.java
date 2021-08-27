package study.jcf.iterable.collection.queue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriorityQueueTest {

    @Test
    @DisplayName("add와 offer의 차이 그리고 poll 하기")
    void addAndOfferAndPoll() {
        PriorityQueue pq = new PriorityQueue();

        pq.add(9);
        pq.add(1);
        pq.add(8);
        pq.offer(10);
        pq.offer(2);

        assertEquals(5, pq.size());

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

        assertEquals(0, pq.size());
    }

    @Test
    @DisplayName("첫번째 있는 데이터 가져오기")
    void peek() {
        PriorityQueue pq = new PriorityQueue();

        pq.add("a");
        pq.add(" ");
        pq.add("A");

        assertEquals(" ", pq.peek());

        while (!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }

    @Test
    @DisplayName("ArrayList로 addAll 시켜보기")
    void addAllList() {
        PriorityQueue pq = new PriorityQueue();

        List<Integer> list = new ArrayList<>();

        list.add(4);
        list.add(1);
        list.add(10);
        list.add(8);

        System.out.println("======= List =======");

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

        pq.addAll(list);

        assertEquals(4, pq.size());
        assertEquals(1, pq.peek());

        System.out.println("======= PriorityQueue =======");

        while (!pq.isEmpty()){
            System.out.println(pq.poll());
        }

    }

    @Test
    @DisplayName("HashMap로 addAll 시켜보기")
    void addAllMap() {
        PriorityQueue pq = new PriorityQueue();
        Map<String, Object> hashMap = new HashMap<String, Object>();

        hashMap.put("first", 4);
        hashMap.put("second", 2);
        hashMap.put("third", 1);
        hashMap.put("4th", 3);

        assertEquals(4, hashMap.size());

        System.out.println(" " + hashMap.values());

        pq.addAll(hashMap.values());

        while (!pq.isEmpty()){
            System.out.print(" " + pq.poll());
        }
    }

    @Test
    @DisplayName("remove와 Clear 차이")
    void removeAndClear() {
        PriorityQueue pq = new PriorityQueue();

        System.out.println("remove method");

        pq.add("A");
        pq.add("1");
        pq.add("a");

        int a = 0;
        while (!pq.isEmpty()){
            a++;
            pq.remove();
            System.out.println(a);
        }

        System.out.println();
        System.out.println("============");
        System.out.println();
        System.out.println("clear method");

        pq.add("A");
        pq.add("1");
        pq.add("a");

        int b = 0;
        while (!pq.isEmpty()){
            b++;
            pq.clear();
            System.out.println(b);
        }
    }
}
