package com.eomcs.lms.handler;
import java.util.Scanner;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberUpdateCommand implements Command {
  
  Scanner keyboard;
  MemberDao memberDao;
  
  public MemberUpdateCommand(Scanner keyboard, MemberDao memberDao) {
    this.keyboard = keyboard;
    this.memberDao = memberDao;
  }
  
  @Override
  public void execute() {

    try {
      System.out.print("번호? ");
      Member member = new Member();
      member.setNo(Integer.parseInt(keyboard.nextLine()));
      
      System.out.print("이름? ");
    member.setName(keyboard.nextLine());
      
      System.out.print("이메일? ");
        member.setEmail(keyboard.nextLine());
      
      System.out.print("암호? ");
        member.setPassword(keyboard.nextLine());
      
      System.out.print("사진? ");
        member.setPhoto(keyboard.nextLine());
      
      System.out.print("전화? ");
        member.setTel(keyboard.nextLine());
      
     if (memberDao.update(member) == 0) {
       System.out.println("해당 회원이 없습니다.");
       return;
     }
      System.out.println("변경했습니다.");
      
    } catch (Exception e) {
      System.out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }
}
