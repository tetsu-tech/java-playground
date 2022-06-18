package io.tetsutech;

import java.util.Arrays;
import java.util.List;

public class StreamTest {
  public static void main(String[] args) {
    System.out.println("withoutStream");
    withoutSteam();
    System.out.println("withStream");
    withStream();
  }

  public static void withoutSteam() {
    List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
    for (Integer i : integerList) {
      if (i % 2 == 0) {
        System.out.println(i);
      }
    }
  }

  public static void withStream() {
    List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
    integerList.stream()
      .filter(i -> i % 2  == 0)
      .forEach(i -> System.out.println(i));
  }
}
