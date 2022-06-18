package io.tetsutech;

public class BuildPatternTest {
  public static void main(String[] args) {
    User user1 = new User.UserBuilder("John", "Doe")
        .age(24)
        .email("john.doe@dex.com")
        .build();

    System.out.println(user1);
    User user2 = new User.UserBuilder("Jack", "Luther")
      .build();

    System.out.println(user2);
  }
}

class User {
  private final String firstName;
  private final String lastName;
  private final int age; // optional
  private final String email; // optional

  private User(UserBuilder builder) {
    this.firstName = builder.firstName;
    this.lastName = builder.lastName;
    this.age = builder.age;
    this.email = builder.email;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getAge() {
    return age;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String toString() {
    return "User: " + this.firstName + ", " + this.lastName + ", " + this.age + ", " + this.email;
  }

  public static class UserBuilder {
    private final String firstName;
    private final String lastName;
    private int age;
    private String email;

    public UserBuilder(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
    }

    public UserBuilder age(int age) {
      this.age = age;
      return this;
    }

    public UserBuilder email(String email) {
      this.email = email;
      return this;
    }

    public User build() {
      User user = new User(this);
      return user;
    }
  }
}
