package design_pattern.composite;

public abstract class Node {
  protected String title;

  public String getTitle() {
    return this.title;
  }

  public abstract void getFileInfo();  // 파일마다 출력 정보 다를 수 있어서 필요에 따라 알아서 정의하라고 추상 메서드로 만든다 

}
