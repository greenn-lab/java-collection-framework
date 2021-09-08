package study.jcf.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class LinkedHashMapTest {


  @Test
  void insetLinkedHashMap() {
    Map<Integer, String> testMap = new LinkedHashMap<>();

    testMap.put(1, "난중일기");
    testMap.put(2, "탈무드");
    testMap.put(3, "안녕,앤");
    testMap.put(4, "리부트");
    testMap.put(5, "호모데우스");

    Collection<String> list = testMap.values();

    assertEquals("리부트", list.toArray()[3]);
  }

  @Test
  void deleteLinkedHashMap() {

    Map<Integer, String> testMap = new LinkedHashMap<>();

    testMap.put(1, "난중일기");
    testMap.put(2, "탈무드");
    testMap.put(3, "안녕,앤");
    testMap.put(4, "리부트");
    testMap.put(5, "호모데우스");

    assertEquals("리부트", testMap.values().toArray()[3]);
    testMap.remove(4);
    testMap.put(4, "배려");

    assertNotEquals("리부트", testMap.values().toArray()[3]);

    testMap.values().forEach(System.out::println);

    testMap.put(5, "안녕");
    assertEquals("안녕", testMap.values().toArray()[3]);

    testMap.values().forEach(System.out::println);


  }

  @Test
  void computeLinkedHashMap() {

    Map<Integer, String> testMap = new LinkedHashMap<>();

    testMap.put(1, "난중일기");
    testMap.put(2, "탈무드");
    testMap.put(3, "안녕,앤");
    testMap.put(4, "리부트");
    testMap.put(5, "호모데우스");

    assertEquals("탈무드", testMap.values().toArray()[1]);
    testMap.compute(2, (k, v) -> /*return*/"갈림길");

    assertNotEquals("탈무드", testMap.values().toArray()[1]);

    testMap.replace(2, "탈무드", "유대인");

    assertNotEquals("유대인", testMap.values().toArray()[1]);

  }


}
