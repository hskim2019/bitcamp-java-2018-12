//[3] 인터페이스를 상속받아 메서드를 구현할 클래스를 만든다

package com.eomcs.lms.listener;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.eomcs.lms.context.ApplicationListener;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;

// 애플리케이션의 상태를 보고 받고 싶다면
// ApplicationListener 규칙에 따라 클래스를 작성해야 한다
public class BoardDataLoaderListener implements ApplicationListener{

  @Override
  public void startApplication(Map<String, Object> context) {
    System.out.println("애플리케이션이 시작될 때 준비 작업을 수행한다");
    //[17] 
    context.put("lessonList",loadLessonData()); 
    context.put("memberList",loadMemberData());
    context.put("boardList",loadBoardData());
  }

  @SuppressWarnings("unchecked")
  @Override
  public void endApplication(Map<String, Object> context) {
    System.out.println("애플리케이션이 종료될 때  마무리 작업을 수행한다"); 

    //[22]
    saveLessonData((List<Lesson>) context.get("lessonList"));
    saveMemberData((List<Member>) context.get("memberList"));
    saveBoardData((List<Board>) context.get("boardList"));

  }

  //[16] App에서 가져온 메서드들 수정하기
  @SuppressWarnings("unchecked")
  private List<Lesson> loadLessonData() {  //리턴 타입을 List로 한 이유 - ArrayList/LinkedList 둘 다 사용 가능하기 때문

    try (ObjectInputStream in = new ObjectInputStream(
        new BufferedInputStream (
            new FileInputStream("lesson3.data")))) {

      return (ArrayList<Lesson>) in.readObject();

    } catch (Exception e) {
      System.out.println("수업 데이터를 읽는 중 오류 발생: " + e.toString());
      return new ArrayList<Lesson>(); //lessondata 로드하다 실패하면 빈 array라도 있어야 하므로

    } 
  }

  //[21] 
  private void saveLessonData(List<Lesson> lessonList) {
    try ( 
        ObjectOutputStream out = new ObjectOutputStream( //[2]
            new BufferedOutputStream(
                new FileOutputStream("lesson3.data")));) {          

      out.writeObject(lessonList);

    } catch (Exception e) {
      System.out.println("수업 데이터를 쓰는 중 오류 발생: " + e.toString());
    }
  }

  @SuppressWarnings("unchecked")
  private List<Member> loadMemberData() {

    try (ObjectInputStream in = new ObjectInputStream (
        new BufferedInputStream(
            new FileInputStream("member3.data")))){

      return (ArrayList<Member>)in.readObject();


    } catch (Exception e) {
      System.out.println("회원 데이터를 읽는 중 오류 발생: " + e.toString());
      return new ArrayList<Member>();

    } 
  }

  private void saveMemberData(List<Member> memberList) {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new BufferedOutputStream(
            new FileOutputStream("member3.data")))) {

      out.writeObject(memberList);

    } catch (Exception e) {
      System.out.println("회원 데이터를 쓰는 중 오류 발생: " + e.toString());
    }
  }


  @SuppressWarnings("unchecked")
  private List<Board> loadBoardData() {

    try(ObjectInputStream in = new ObjectInputStream(
        new BufferedInputStream(
            new FileInputStream("board3.data")))) {

      return (ArrayList<Board>) in.readObject();

    } catch (Exception e) {
      System.out.println("게시글 데이터를 읽는 중 오류 발생: " + e.toString());
      return new ArrayList<Board>();
    }
  } 


  private void saveBoardData(List<Board> boardList) {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new BufferedOutputStream(
            new FileOutputStream("board3.data")))) {

      out.writeObject(boardList);

    } catch (Exception e) {
      System.out.println("게시글 데이터를 쓰는 중 오류 발생: " + e.toString());
    }
  }

}
