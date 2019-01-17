package com.bitcamp.lms.handler;

import java.util.Arrays;
import com.bitcamp.lms.domain.Board;

public class BoardList {

  static final int LENGTH = 10;  //=> [1]board handler에서 가져 옴
  Board[] arr = new Board[LENGTH]; // =>[1]board handler에서 가져 옴, 배열이라 변수이름 arr로 변경
  int size = 0;   // => [1]board handler에서 가져 옴/ boardidx -> size로 변수명 바꿈

  // [4]배열 리턴하는 메서드
  // 메서드 형태 : [리턴받을 데이터 타입] [메서드 이름](파라미터)
  public Board[] toArray() { // 데이터 복사, 같은 사이즈가 되도록 복사하자
    Board[] a = new Board[this.size]; // 위에 이미 arr로 배열 만든것은 길이 10개뿐임, 새로 a로 배열 만듦
    for (int i = 0; i < this.size; i++) {
      a[i] = this.arr[i];  // arr로 받은 주소값을 a배열에 복사해서 넣기
    }
    return a;   // 메서드 toArray()는 리턴타입이 Board클래스에 만들어 둔 배열
  }

  // [3]데이터 저장하는 메서드
   // boards[boardIdx] = board; // BoardHandler에서 배열마다 값을 넣었었음
   // 처음 배열[0부터++] = keyboard로 입력받은 내용
  public void add(Board board) {
    // 10개 이상의 배열도 들어가야 하므로 if 문 추가 , 현재 개수보다 50% 증가시키기
    // >> 오른쪽으로 비트이동 하나 하면 나누기 2
    if (size == arr.length) {
      Board[] a = new Board[arr.length + (arr.length >> 1)]; //[3-2] // 배열길이 다 차면 늘려주기
      // 윗 부분은 새로배열 만든 것, 이제 복사해야함
      for(int i = 0; i < arr.length; i ++) {//[3-3] 주소값 복사해오기
        a[i] = arr[i];
      }
      arr = a;  //배열을 계속 증가시킬 수 있다 [3-4] arr도 size와 같이 증가시키기, arr초기값은 10이므로
    }
    arr[size++] = board;  //[3-1] BoardHandler에서 입력받은 board값을 arr주소가 가리키게 하기
  }





}