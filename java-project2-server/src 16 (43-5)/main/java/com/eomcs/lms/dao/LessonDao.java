// 프록시 패턴 적용 - LessonDao에서 인터페이스를 추출한다.
package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Lesson;

public interface LessonDao {
  void insert(Lesson lesson);
  List<Lesson> findAll();
 // List<Lesson> findByKeyword(String keyword);
  Lesson findByNo(int no);
  int update(Lesson lesson);
  int delete(int no);
}







