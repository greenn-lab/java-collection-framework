package study.jcf.map.sortedmap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Map.Entry;
import java.util.TreeMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TreeMapTest {

  @Test
  void 트리맵_기본_생성자() {
    TreeMap<String, Integer> tree = new TreeMap<>();

    assertNotNull(tree);
  }

  @Test
  void 트리맵_데이터입력() {
    TreeMap<String, Integer> tree = new TreeMap<>();

    tree.put("test", 123);
    tree.put("test1", 456);

    assertEquals(2, tree.size());

    final Entry<String, Integer> entry = tree.ceilingEntry("test");
    assertEquals(123, entry.getValue());

    final Entry<String, Integer> entry2 = tree.ceilingEntry("test1");
    assertEquals(456, entry2.getValue());
  }

  @Test
  void 안써본_메서드_테스트() {
    TreeMap<String, Integer> tree = new TreeMap<>();

    tree.put("test", 123);
    tree.put("test1", 456);

    assertEquals(123, tree.ceilingEntry("test").getValue());
    assertEquals(123, tree.floorEntry("test").getValue());
  }

  @Test
  void 중복가능성테스트() {
    TreeMap<String, Integer> tree = new TreeMap<>();

    tree.put("test", 123);
    tree.put("test1", 456);

    tree.put("test", 789);

    assertEquals(2, tree.size());
  }

  @Test
  void 순서보장확인테스트() {
    TreeMap<Integer, String> tree = new TreeMap<>();

    for (int i = 0; i < 10000; i++) {
      tree.put(i, Integer.toString(i));
    }

    final Entry<Integer, String> last = tree.lastEntry();

    assertEquals(9999, last.getKey());
    assertEquals("9999", last.getValue());

    tree.keySet().stream().forEach(System.out::println);
  }
}
