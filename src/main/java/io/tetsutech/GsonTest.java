package io.tetsutech;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;

public class GsonTest {
  public static void main(String[] args) {
    Company company = new Company("Apple", 10);
    Employee employee = new Employee(1234, "Michael", "m1123@google.com", company);

    Gson gson = new Gson();
    String jsonString = gson.toJson(employee);
    System.out.println(jsonString);
  }
}

class Employee {
  private long id;
  private String name;
  private String email;
  private List<Branch> branches;
  private Company company;

  Employee(long id, String name, String email, Company company) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.branches = new ArrayList<Branch>(Arrays.asList(
        new Branch("Biz"),
        new Branch("Dev")));
    this.company = company;
  }

  @Override
  public String toString() {
    return "Employee { id: " + id
        + ", name: " + name
        + ", email: " + email + " }";
  }
}

class Branch {
  private String name;

  Branch(String name) {
    this.name = name;
  }
}

class Company {
  private String name;
  private Integer numberOfEmployees;

  Company(String name, Integer numberOfEmployees) {
    this.name = name;
    this.numberOfEmployees = numberOfEmployees;
  }
}
