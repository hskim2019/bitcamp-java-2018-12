# 44
- <sql>
- <bind>
- <foreach>

15단계: Mybatis의 동적 SQL(dynamic sql) 적용하기
 => 하나의 SQL문으로 여러 요청을 처리할 수 있도록 mybatis는 동적 SQL 문법을 제공한다

 작업:
 1) SQL 매퍼 파일 변경
   => BoardMapper.xml, LessonMapper.xml, MemberMapper.xml, PhotoBoardMapper.xml, PhotoFileMapper.xml
   => <sql> 태그 사용 : select문에 공통으로 들어가는 컬럼 목록을 별도로 분리하여 관리한다.
   => <bind> 태그 사용: 파라미터 값을 가지고 SQL을 생성할 때 사용한다.
   => <foreach> 태그 사용: 사진 파일을 첨부할 때 매번 insert하지 않고 List에 담아 한 번에 insert