package study.jcf.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HashtableTest {

  @Test
  @DisplayName("Hashtable.put, putAll() : 새로운 키-값 추가")
  void putAndPutAll() {
    final Hashtable<String, Number> numbers = new Hashtable<>();
    numbers.put("one", 1);
//주석
    assertEquals(1, numbers.size());

    Map<String, Number> adds = new HashMap<>(3);
    adds.put("two", 2L);
    adds.put("three", 3.123_456D);
    adds.put("four", 4.000_12F);

    numbers.putAll(adds);

    assertEquals(4, numbers.size());
  }

  @Test
  @DisplayName("Hashtable.contains,containsKey,containsValue() : 가지고있어요?")
  void containsAndContainsKeyAndContainsValue() {
    // GIVEN
    // WHEN
    final Hashtable<String, Number> numbers = new Hashtable<>();
    numbers.put("one", 1);
    numbers.put("two", 2F);

    // THEN
    assertTrue(numbers.contains(1));
    assertTrue(numbers.containsKey("one"));
    assertFalse(numbers.containsKey("three"));
    assertTrue(numbers.containsValue(2F));
    assertFalse(numbers.containsValue(1L));
  }

  @Test
  @DisplayName("Hashtable.remove, clear() : 잘 지워지겠지?")
  void removeAndClear() {
    final Hashtable<String, Number> numbers = new Hashtable<>();
    numbers.put("one", 1);
    numbers.put("two", 2L);
    numbers.put("three", 3.123_456D);
    numbers.put("four", 4.000_12F);

    numbers.remove("two");
    assertEquals(3, numbers.size());

    numbers.clear();
    assertEquals(0, numbers.size());
  }

  @Test
  @DisplayName("Hashtable.elements,values,keys() : 다른 형식으로 추출해보기")
  void elementsAndValuesAndKeys() {
    final Hashtable<String, Number> numbers = new Hashtable<>();
    numbers.put("one", 1);
    numbers.put("two", 2L);
    numbers.put("three", 3.123_456D);
    numbers.put("four", 4.000_12F);

    final Enumeration<Number> elements = numbers.elements();
    while (elements.hasMoreElements()) {
      final Number number = elements.nextElement();
      assertTrue(number instanceof Number);
    }

    final Collection<Number> values = numbers.values();
    for (Number number : values) {
      assertTrue(number instanceof Number);
    }

    final Optional<Number> sum = numbers.values().stream()
        .reduce((a, b) -> Double.sum(a.doubleValue(), b.doubleValue()));

    assertEquals(10, sum.orElseThrow(NullPointerException::new).intValue());
  }

}
