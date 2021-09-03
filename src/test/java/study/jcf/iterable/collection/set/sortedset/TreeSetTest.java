package study.jcf.iterable.collection.set.sortedset;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NavigableSet;
import java.util.TreeSet;

class TreeSetTest {

    @Test
    @DisplayName("subSet 메소드")
    void test() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        TreeSet<Integer> subTreeSet = new TreeSet<>();

        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(5);

        subTreeSet = (TreeSet<Integer>) treeSet.subSet(3, true,5,false);
        treeSet.add(4);

        assertEquals(5, treeSet.size());
        assertEquals(2, subTreeSet.size());
    }

    @Test
    @DisplayName("first, last, lower, higher, floor, ceiling 메소드")
    void test2() {
        TreeSet<Integer> treeSet = new TreeSet<Integer>();

        treeSet.add(10);
        treeSet.add(2);
        treeSet.add(30);
        treeSet.add(25);

        for (int set : treeSet){
            System.out.println(set + " ");
        }

        assertEquals(2, treeSet.first());
        assertEquals(30, treeSet.last());
        assertEquals(10, treeSet.lower(25));
        assertEquals(30, treeSet.higher(25));
        assertEquals(25, treeSet.floor(26));
        assertEquals(30, treeSet.ceiling(26));

    }

    @Test
    @DisplayName("pollFirst, pollLast 메소드")
    void test3() {
        TreeSet treeSet = new TreeSet();

        treeSet.add(10);
        treeSet.add(2);
        treeSet.add(30);
        treeSet.add(25);

        assertEquals(2, treeSet.pollFirst());
        assertEquals(10, treeSet.first());
        assertEquals(30, treeSet.pollLast());
        assertEquals(25, treeSet.last());

    }

    @Test
    @DisplayName("descendingSet 메소드")
    void test4() {
        TreeSet<Integer> treeSet = new TreeSet<Integer>();

        treeSet.add(10);
        treeSet.add(2);
        treeSet.add(30);
        treeSet.add(25);
        treeSet.add(100);
        treeSet.add(1);

        NavigableSet<Integer> decendingSet = treeSet.descendingSet();

        for (int treeset : decendingSet){
            System.out.println(treeset + " ");
        }
    }

    @Test
    @DisplayName("headSet 과  tailSet의 차이")
    void test5() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        TreeSet<Integer> headTreeSet = new TreeSet<>();
        TreeSet<Integer> tailTreeSet = new TreeSet<>();

        treeSet.add(10);
        treeSet.add(2);
        treeSet.add(30);
        treeSet.add(25);

        headTreeSet = (TreeSet<Integer>) treeSet.headSet(10, true);
        tailTreeSet = (TreeSet<Integer>) treeSet.tailSet(10, true);

        for (int head : headTreeSet){
            System.out.print(head + " ");
        }

        System.out.println();

        for (int tail : tailTreeSet){
            System.out.print(tail + " ");
        }
    }
}
