package study.jcf.iterable.collection.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ArrayListTest {

  @Test
  @DisplayName("ArrayList.add() : 새로운 요소를 넣어요.")
  void add() {
    // GIVEN
    final String string = "A";
    final ArrayList<String> strings = new ArrayList<>();

    // WHEN
    strings.add(string);

    // THEN
    assertEquals(strings.size(), 1);
    assertEquals(strings.get(0), string);
  }

  @Test
  @DisplayName("ArrayList.addAll() : 새로운 요소를 왕창 넣어요.")
  void addAll() {
    // GIVEN
    final String stringA = "A";
    final ArrayList<String> strings = new ArrayList<>();

    strings.add(stringA);

    final List<String> adds = Arrays.asList("B", "C");

    // WHEN
    strings.addAll(adds);

    // THEN
    assertEquals(3, strings.size());
    assertEquals("ABC", String.join("", strings));
  }

  @Test
  @DisplayName("ArrayList.remove, removeAll() : 하나씩 지워요.")
  void remove() {
    // GIVEN
    final String stringA = "A";
    final String stringB = "B";
    final String stringC = "C";
    final ArrayList<String> strings = new ArrayList<>();

    strings.add(stringA);
    strings.add(stringB);
    strings.add(stringC);

    // WHEN
    strings.remove(1);

    // THEN
    assertEquals("AC", String.join("", strings));
  }

  @Test
  @DisplayName("ArrayList.removeIf() : 마구마구 지워요.")
  void removeIf() {
    // GIVEN
    final String stringA = "A";
    final String stringB = "B";
    final String stringC = "C";
    final ArrayList<String> strings = new ArrayList<>();

    strings.add(stringA);
    strings.add(stringB);
    strings.add(stringC);

    // WHEN
    strings.removeIf(i -> i.compareTo("B") >= 0);

    // THEN
    assertEquals("A", String.join("", strings));
  }

  @Test
  @DisplayName("ArrayList.removeAll() : 왕창 지워요.")
  void removeAll() {
    // GIVEN
    final String stringA = "A";
    final String stringB = "B";
    final String stringC = "C";
    final ArrayList<String> strings = new ArrayList<>();

    strings.add(stringA);
    strings.add(stringB);
    strings.add(stringC);

    // WHEN
    strings.removeAll(Arrays.asList("A", "B"));

    // THEN
    assertEquals("C", String.join("", strings));
  }

  @Test
  @DisplayName("ArrayList.clear() : 모조리 지워요.")
  void clear() {
    // GIVEN
    final String stringA = "A";
    final String stringB = "B";
    final String stringC = "C";
    final ArrayList<String> strings = new ArrayList<>();

    strings.add(stringA);
    strings.add(stringB);
    strings.add(stringC);

    // WHEN
    strings.clear();

    // THEN
    assertEquals(0, strings.size());
  }


  @Test
  @DisplayName("ArrayList.isEmpty, contains() : 비었는지 확인하고, 요소가 포함됐는지 확인해요.")
  void isEmptyAndContains() {
    // GIVEN
    final String string = "A";
    final ArrayList<String> strings = new ArrayList<>();

    // WHEN
    strings.add(string);

    // THEN
    assertFalse(strings.isEmpty());
    assertTrue(strings.contains(string));
  }

  @Test
  @DisplayName("ArrayList.iterator,toArray() : 반복적인 구조와 배열 구조를 가져 봐요.")
  void iteratorAndToArray() {
    // GIVEN
    final String stringA = "A";
    final String stringB = "B";
    final String stringC = "C";
    final ArrayList<String> strings = new ArrayList<>();

    // WHEN
    strings.add(stringA);
    strings.add(stringB);
    strings.add(stringC);

    // THEN
    final Iterator<String> it = strings.iterator();
    while (it.hasNext()) {
      final String string = it.next();
      assertTrue(string.matches("[ABC]"));
    }

    final String[] array = strings.toArray(new String[0]);
    for (String string : array) {
      assertTrue(string.matches("[ABC]"));
    }
  }
}
