package study.jcf.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Set;

import org.junit.jupiter.api.Test;

class HashMapTest {

    @Test
    void insertHashMap(){
        HashMap<String, Integer> tstMap = new HashMap<String, Integer>();

        tstMap.put("A", 123);

        assertEquals(123, tstMap.get("A"));

    }

    @Test
    void removeHashMap(){
        HashMap<String, Integer> tstMap = new HashMap<String, Integer>();

        tstMap.put("A", 123);
        tstMap.put("B", 456);
        tstMap.put("C", 111);
        tstMap.put("D", 222);
        tstMap.put("E", 222);

        assertEquals(5, tstMap.size());

        tstMap.remove("D");

        assertEquals(true, !tstMap.containsKey("D"));

    }

    @Test
    void insertAllHashMap(){
        HashMap<String, Integer> sourceMap = new HashMap<String, Integer>();
        HashMap<String, Integer> tartgetMap = new HashMap<String, Integer>();

        sourceMap.put("A", 123);
        sourceMap.put("B", 456);
        sourceMap.put("C", 111);
        sourceMap.put("D", 222);
        sourceMap.put("E", 222);

        tartgetMap.putAll(sourceMap);

        assertEquals(111, tartgetMap.get("C"));

        assertTrue(tartgetMap.size()==5);

    }

    @Test
    void cloneHashMap(){
        HashMap<String, Integer> sourceMap = new HashMap<String, Integer>();

        sourceMap.put("A", 123);
        sourceMap.put("B", 456);
        sourceMap.put("C", 111);
        sourceMap.put("D", 222);
        sourceMap.put("E", 222);

        @SuppressWarnings("unchecked")
        HashMap<String, Integer> targetMap = (HashMap<String, Integer>) sourceMap.clone();
        
        assertTrue(targetMap.equals(sourceMap));
    }

    @Test
    void entrySetTest(){
        HashMap<String, Integer> sourceMap = new HashMap<String, Integer>();

        sourceMap.put("A", 123);
        sourceMap.put("B", 456);
        sourceMap.put("C", 111);
        sourceMap.put("D", 222);
        sourceMap.put("E", 222);

        Set<?> sets = sourceMap.entrySet();

        System.out.println(sets);

        assertEquals(5, sets.size());
        


    }

}
