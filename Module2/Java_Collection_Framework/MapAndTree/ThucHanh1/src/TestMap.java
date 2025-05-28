import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestMap {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("one", 1);
        hashMap.put("two", 2);
        hashMap.put("three", 3);
        hashMap.put("two", 3);
        hashMap.put("three", 3);
        hashMap.put("four", 4);
        hashMap.put("four", 4);
        hashMap.put("five", 5);
        hashMap.put("twenty", 20);
        hashMap.put("twenty", 20);
        System.out.println(hashMap);// co the khac key nhung cung gia tri, khong lap

        Map<String, Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println(treeMap);

        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("one", 1);
        linkedHashMap.put("two", 2);
        linkedHashMap.put("three", 3);
        linkedHashMap.put("three", 3);
        linkedHashMap.put("four", 4);
        linkedHashMap.put("two", 4);
        linkedHashMap.put("twenty", 20);
        System.out.println(linkedHashMap.get("two"));
    }
}
 