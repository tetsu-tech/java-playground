package io.tetsutech;

public class BitwiseAndBitShiftTest {
  public static void main(String[] args) {
    int bitmask = 0x000F;
    int val = 0x2224;

    // prints "2"
    // ANDをとるので、0x0002になって出力は2
    System.out.println(val & bitmask);

    // XORをとる
    System.out.println(val ^ bitmask);

    // ORをとる
    System.out.println(val | bitmask);

    // 00000000000000000000000000000101 >> 1 =  00000000000000000000000000000010
    System.out.println("5 >> 1 = " + (5 >> 1));

    // 0101 << 1 =  1010
    // 00000000000000000000000000000101 >> 1 =  00000000000000000000000000001010
    System.out.println("5 << 1 = " + (5 << 1));

    // ~00000000000000000000000000000101 = 11111111111111111111111111111010
    System.out.println("~5 = " + ~5);
  }
}
