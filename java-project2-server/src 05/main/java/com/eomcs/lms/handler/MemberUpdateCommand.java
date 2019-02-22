package com.eomcs.lms.handler;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberUpdateCommand extends AbstractCommand {

  MemberDao memberDao;

  public MemberUpdateCommand(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void execute (Response response) throws Exception {

      Member member = new Member();
      member.setNo(response.requestInt("번호? "));
      member.setName(response.requestString("이름? "));
      member.setEmail(response.requestString("이메일? "));
      member.setPassword(response.requestString("암호? "));
      member.setPhoto(response.requestString("사진? "));
      member.setTel(response.requestString("전화? "));
      
      if (memberDao.update(member) == 0) {
        response.println("해당 회원이 없습니다.");
        return;
      }
      response.println("변경했습니다.");

  }
}
