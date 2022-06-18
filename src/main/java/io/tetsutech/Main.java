package main.java.io.tetsutech;

public class Main {
  public static void main(String[] args) {
    // Hello Javaを表示する
    System.out.println("Hello Java");

    System.out.println("args:");
    // 引数の値を取得する
    for (int i = 0; i < args.length; i++) {
      System.out.println(" - " + args[i]);
    }
  }
}
