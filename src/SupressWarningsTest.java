public class SupressWarningsTest {
  // SupressWariningを使用することでDeprecatedのwarnが出るのを抑制する
  @SuppressWarnings("deprecation") // 非推奨のメンバーを使用
  public static void main(String[] args) {
    new WithDeprecated().testMethod();
  }
}

class WithDeprecated {
  @Deprecated
  public void testMethod() {
    System.out.println("this is deprecated method");
  }
}
