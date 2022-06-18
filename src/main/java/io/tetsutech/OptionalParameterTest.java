package io.tetsutech;

import java.util.Optional;

// 
public class OptionalParameterTest {
  public static void main(String[] args) {
    StudentWithOfNullable("John", null, 25);
  }

  private static void StudentWithOfNullable(String name, String lastName, int age) {
    // nullを受け入れる場合はofNullableを使う
    Optional<String> nullableLastName = Optional.ofNullable(lastName);
    String _lastName = nullableLastName.isPresent() ? nullableLastName.get() : "Not Provided";

    System.out.println("name: " + name + ", lastname: " + _lastName + ", age: " + age);
  }
}
