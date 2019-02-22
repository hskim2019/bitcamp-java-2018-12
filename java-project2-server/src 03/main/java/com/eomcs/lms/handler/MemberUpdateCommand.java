package com.eomcs.lms.handler;
import java.io.BufferedReader;
import java.io.PrintWriter;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberUpdateCommand implements Command {

  MemberDao memberDao;

  public MemberUpdateCommand(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void execute(BufferedReader in, PrintWriter out) {

    try {
      out.println("번호? ");
      out.println("!{}!");
      out.flush();

      Member member = new Member();
      member.setNo(Integer.parseInt(in.readLine()));

      out.println("이름? ");
      out.println("!{}!");
      out.flush();
      member.setName(in.readLine());

      out.println("이메일? ");
      out.println("!{}!");
      out.flush();
      member.setEmail(in.readLine());

      out.println("암호? ");
      out.println("!{}!");
      out.flush();
      member.setPassword(in.readLine());

      out.println("사진? ");
      out.println("!{}!");
      out.flush();
      member.setPhoto(in.readLine());

      out.println("전화? ");
      out.println("!{}!");
      out.flush();
      member.setTel(in.readLine());
      
      if (memberDao.update(member) == 0) {
        out.println("해당 회원이 없습니다.");
        return;
      }
      out.println("변경했습니다.");

    } catch (Exception e) {
      out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }
}
