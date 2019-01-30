package design_pattern.composite;

public class Test01 {

  public static void main(String[] args) {

    // Composite 디자인 패턴 :
    // => tree 구조로 전체-부분 관계의 객체를 표현할 때 사용한다
    // => 보통 조직도를 표현할 때 적합하다
    // => OS의 파일시스템도 이 설계 기법으로 구현할 수 있다
    //
    // 다음은 OS의 파일과 디렉토리 관계를 Composite 패턴을 사용하여 tree 구조로 표현한 것이다
    
    Directory root = new Directory("/");

    root.add(new File("a.gif", "image/gif", 3456));
    root.add(new File("b.gif", "imagie/gif", 34530));
    root.add(new File("text.txt", "text/plain", 8700));

    Directory src = new Directory("/src");
    src.add(new File("Hello.java", "text/java", 320));
    src.add(new File("Hello2.java", "text/java", 400));
    root.add(src);

    Directory bitcamp =  new Directory("/bitcamp");
    bitcamp.add(new File("A.java", "text/java", 200));
    src.add(bitcamp);

    display(root, "");

  }

  static void display(Directory dir, String path) {
    System.out.println(path);

    for (Node node : dir.childs) { //directory에 들어있는 childs갯수만큼 반복문 돌기
      if (node instanceof File) {  // 만약 꺼낸 것이 File이면
        System.out.printf("%s/%s\n", path, node.getTitle());

      } else if (node instanceof Directory) {  // 만약 꺼낸 것이 File이 아니라 자식 directory면 directory를 출력하라
        display((Directory)node, path + node.getTitle());    // (Directory) ; typecasting
      }
    }
  }

}
