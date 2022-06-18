package io.tetsutech;

public class LongTest {
  public static void main(String[] args) {
    long a = 2147483647;

    // Int型：-2147483648 ~ 2147483647 なのでそれ以上の値はLを付けて表現しないといけない
    // long型：-9223372036854775808 ~ 9223372036854775807 まで扱える
    long b = 2147483648l;
    long c = 2147483649l;

    System.out.println("a = " + a);
    System.out.println("b = " + b);
    System.out.println("c = " + c);
  }
}
