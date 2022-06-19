package io.tetsutech;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PairtTest {
  public static void main(String[] args) throws Exception {
    Map<Integer, String> map1 = new HashMap<>();
    map1.put(1, "value");
    Pair<String, Map<Integer, String>> pair1 = new Pair<>("pair1", map1);
    System.out.println(pair1.equals(pair1));
  }
}

final class Pair<T1, T2> {

  public final T1 car;
  public final T2 cdr;

  public Pair(T1 a1, T2 a2) {
    this.car = a1;
    this.cdr = a2;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Pair<?, ?> pair = (Pair<?, ?>) o;
    return Objects.equals(car, pair.car) && Objects.equals(cdr, pair.cdr);
  }

  @Override
  public int hashCode() {
    return Objects.hash(car, cdr);
  }

  @Override
  public String toString() {
    return "Pair [car=" + this.car + ", cdr=" + this.cdr + "]";
  }
}
