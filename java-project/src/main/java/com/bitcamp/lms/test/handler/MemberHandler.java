package com.bitcamp.lms.test.handler;

import java.sql.Date;
import java.util.Scanner;
import com.bitcamp.lms.test.domain.Member;

public class MemberHandler {

  public Scanner keyboard;
  final int LENGTH =10;
  
  Member[] members = new Member[LENGTH];
  int memberIdx = 0;
  
  public void listMember() {
    for(int c = 0; c < memberIdx; c++) {
      System.out.printf("%d, %-4s, %-20s, %15s, %s\n ", members[c].no, members[c].name, members[c].email, members[c].phone, members[c].regDate);
    }
    System.out.println();
  }

  public void addMember() {
    Member member = new Member();

    System.out.print("번호? ");
    member.no = Integer.parseInt(keyboard.nextLine());

    System.out.print("이름? ");
    member.name = keyboard.nextLine();

    System.out.print("이메일? ");
    member.email = keyboard.nextLine();

    System.out.print("암호? ");
    member.pw = Integer.parseInt(keyboard.nextLine());

    System.out.print("사진? ");
    member.pic = keyboard.nextLine();

    System.out.print("전화? ");
    member.phone = keyboard.nextLine();

    System.out.print("가입일? ");
    member.regDate = Date.valueOf(keyboard.nextLine());

    members[memberIdx++] = member;

    System.out.println();
  }
}
