package io.tetsutech;

public class OverrideTest extends TestOverride {
  // MEMO: Override annotationをつけることでメソッドがOverrideされることを保証する
  // @Override
  public void outputs() {
    System.out.println("Hello World!");
  }

  public static void main(String[] args) {
    TestOverride testOverride = new TestOverride();
    testOverride.outputs();
  }
}

class TestOverride {
  // Overrideしてこっちが実行される
  public void outputs() {
    System.out.println("Hello World Override!");
  }
}
