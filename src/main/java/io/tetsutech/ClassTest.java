package io.tetsutech;

public class ClassTest {
  public static void main(String[] args) {
    Counter counter = new Counter(0);
    counter.increment();
    System.out.println(counter.count);
    counter.decrement();
    System.out.println(counter.count);

    System.out.println(counter.toString());
  }
}

class Counter {
  public int count;

  public Counter(int count) {
    this.count = count;
  }

  public void increment() {
    this.count++;
  }

  public void decrement() {
    this.count--;
  }

  @Override
  public String toString() {
    return "Conter{"
        + "count="
        + count
        + '}';
  }
}
