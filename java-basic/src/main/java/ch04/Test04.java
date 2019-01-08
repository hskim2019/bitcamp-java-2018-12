// 암시적 형변환
package ch04;

public class Test04 {
  public static void main(String[] args) {
    float r = 5 / 2 + 3.2f;
    System.out.println(r);
     // 암시적 형변환에 의해
     // 5와 2는 지정해주지 않으면 int임
    //  5(int) / 2(int) = 2.5(x) 2(o)
    //   2 + 3.2(float) = 5.2f
    
    double r1 = (double)5 / 2+ 3;
    System.out.println(r1);
  }
}
