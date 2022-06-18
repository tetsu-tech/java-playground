package main.java.io.tetsutech;

public class SupressWarningsTest {
  // SupressWariningを使用することでDeprecatedのwarnが出るのを抑制する
  @SuppressWarnings("deprecation") // 非推奨のメンバーを使用
  public static void main(String[] args) {
    new WithDeprecated2().testMethod();
  }
}

class WithDeprecated2 {
  @Deprecated
  public void testMethod() {
    System.out.println("this is deprecated method");
  }
}
