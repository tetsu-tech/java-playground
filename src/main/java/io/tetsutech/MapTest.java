package io.tetsutech;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
  public static void main(String[] args) {
    Map<Integer, String> map = new HashMap<>();

    map.put(1, "value1");
    map.put(2, "value2");
    map.put(3, "value3");

    for (String val: map.values()) {
      System.out.println(val);
    }
  }
}
