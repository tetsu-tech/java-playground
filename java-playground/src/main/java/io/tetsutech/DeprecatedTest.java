package io.tetsutech;

public class DeprecatedTest {
  public static void main(String[] args) {
    new WithDeprecated().testMethod();
  }  
}

class WithDeprecated {
  // MEMO: deprecated annotationをつけたメソッドを実行するとwarningが発生する
  @Deprecated
  public void testMethod() {
    System.out.println("this is deprecated method");
  }
}
