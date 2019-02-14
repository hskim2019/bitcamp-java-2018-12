package com.eomcs.lms.dao;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
// 읽어들인 데이터를  file로 저장하는 추상 클래스

public abstract class AbstractDao<E> {
  protected List<E> list;       // 상속받은 클래스가 접근할 수 있도록, 다른 패키지에 서브 클래스를 만들수도 있으므로 protected로 
  protected String filepath;

  @SuppressWarnings("unchecked")
  public void loadData() {

    try(ObjectInputStream in = new ObjectInputStream(
        new BufferedInputStream(
            new FileInputStream(this.filepath)))) {

      list = (List<E>) in.readObject();

    } catch (Exception e) {
      list = new ArrayList<E>();
      throw new RuntimeException("데이터 파일 로딩 오류!", e);
    }
  }

  public void saveData() throws Exception {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new BufferedOutputStream(
            new FileOutputStream(this.filepath)))) {

      out.writeObject(list);

    } catch (Exception e) {
      throw new RuntimeException("데이터 파일 저장 오류!", e);
    }
  }

}
