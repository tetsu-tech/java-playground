package main.java.io.tetsutech;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListTest {

  public static void main(String[] args) {
    declareByList();
    declareByArrayList();
  }

  public static void declareByList() {
    // 宣言の型にListを使う場合
    List<Integer> arrayList = new ArrayList<Integer>();
    arrayList.add(10);
    arrayList.add(20);
    arrayList.add(30);

    // ArrayListからLinkedListへの変換
    LinkedList<Integer> linkedList = new LinkedList<Integer>(arrayList);
    LinkedList<Integer> linkedListCloned = (LinkedList<Integer>) linkedList.clone();
    for (Integer item : linkedListCloned) {
      System.out.println(item);
    }
  }

  public static void declareByArrayList() {
    // 宣言の型にArrayListを使う場合
    ArrayList<Integer> arrayList = new ArrayList<Integer>();
    arrayList.add(10);
    arrayList.add(20);
    arrayList.add(30);

    // ArrayListのコピー
    //cloneはListインターフェースには存在せず、ArrayListにしかないのでこれを使いたい場合は宣言はArrayListで行いっておいたほうがよいらしい
    ArrayList<Integer> bar = (ArrayList<Integer>) arrayList.clone();
    for (Integer i : bar) {
      System.out.println(i);
    }
  }
}
