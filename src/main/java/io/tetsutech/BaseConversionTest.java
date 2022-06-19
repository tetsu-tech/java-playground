package io.tetsutech;

public class BaseConversionTest {
  public static void main(String[] args) {
    Integer i1 = Integer.parseInt("0002", 16);
    System.out.println("0x0002 → " + i1);
    
    Integer i2 = Integer.parseInt("2222", 16);
    System.out.println("0x2222 → " + i2);
  }
}
