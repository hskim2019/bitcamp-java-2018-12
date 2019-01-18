package ch16;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Prc2 {
  public static void main(String[] args) {

    String[] str = creat2(new String[0]);
    System.out.println(str.length); //빈 배열을 넘겼지만 메서드를 통해 배열길이 10 됨

    String[] str2 = creat2(new String[100]);
    System.out.println(str2.length);
    System.out.println(str == str2);
    
    String[] str3 = creat3(String.class);
    System.out.println(str3.length);
    
    String[] str4 = creat4(new String[1]);
    System.out.println(str4.length);
  }

  static <T> T[] creat1() {
    return null;
  }

  static <T> T[] creat2(T[] arr) {
    return Arrays.copyOf(arr, 10);
  }

  static <T> T[] creat3(Class<?> type) {
    return (T[]) Array.newInstance(type, 10);
  }

  static <T> T[] creat4(T[] arr) {
    return (T[]) Array.newInstance(arr.getClass(), 10);
  }
}

