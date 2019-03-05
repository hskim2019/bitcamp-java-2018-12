#39-1 (=src09)

// 9단계: 서버에서 클라이언트 요청을 순차적으로 처리할 때 문제점과 그 해결책
- Stateful + 싱글 Thread => Stateful + 멀티 Thread로 변경하기
- Thread가 커넥션을 공유할 때의 문제점 :

// [서버에서 클라이언트 요청을 처리하는 방법]
// 1) Stateful 방식
//     - 서버와 연결한 후 연결을 끊을 때까지 계속 통신하는 방식이다
//     - 클라이언트가 연결을 끊지 않으면 서버쪽에 계속 소켓이 유지되기 때문에 메모리를 일정 점유한다
//     - 그래서 많은 클라이언트의 요청을 처리하지 못한다
// 2) Stateless 방식
//     - 서버와 연결한 후 요청/응답을 한 번만 수행한다. 그리고 연결을 끊는다.
//     - 서버에서 응답을 완료하면 자동으로 연결을 끊기 때문에 서버 쪽에 소켓을 계속 유지하지 않는다.
//     - 그래서 Stateful 방식에 비해 메모리 낭비가 덜하다. 
//     - 단 요청할 때 마다 서버와 연결해야 하기 때문에 연결하는 데 일정 시간이 소요된다.
//     - 그러나 보다 많은 클라이언트 요청을 처리할 수 있어 대부분의 서비스에서 이 방식을 많이 사용한다.
// 3) Stateless 방식 + 멀티스레드
//     - 특히 Stateless 방식에 멀티스레드를 적용하면 동시에 많은 클라이언트 요청을 처리할 수 있다
//     - 대부분의 서비스들이 이 조합을 사용한다

// 9 단계의 목표가 "Stateless + 싱글 스레드" 방식을 "Stateless + 멀티 스레드"로 바꾸는 것이다
// 작업:
// 1) 클라이언트 요청 처리를 전달할 스레드 클래스를 정의한다
//   => RequestHandlerThread
// 2) ServiceApp의 service()가 수행하던 클라이어늩 요청 처리를 RequestHandlerThread로 옮긴다
// 