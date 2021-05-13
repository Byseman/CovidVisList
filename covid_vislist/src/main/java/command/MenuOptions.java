/*
MenuOptions.java
- Command 패턴의 요소인 Invoker 객체에 해당
- 회원가입, 로그인, 로그아웃 메뉴에 대해 사용자 입력을 받음
*/
package command;

public class MenuOptions {
  private ActionListenerCommand command;
  // select() 메소드에서 사용할 변수 선언-BoUML 미적용 Attribute
  // 사용자 선택값에 대해 값을 저장할 필요가 있음.
  private int i;

  public void setCommand(ActionListenerCommand command) {
      this.command = command;
  }

  // 메소드 select()에서 사용자가 이용하길 원하는 메뉴에 대한 연결을 진행
  // 1-회원가입, 2-로그인, 3-로그아웃
  // (3번 기능은 로그인 상태에서 활성화)
  public void select() {
      // 파일 입출력 기능 확인을 위한 테스트 코드
      command.execute();
  }

}
