/*
ActionSignin.java
- Command 패턴의 요소인 ConcreteCommand 객체에 해당
*/

package command;

public class ActionSignin implements ActionListenerCommand {
  private Signin signin;

  public ActionSignin(Signin signin) {
      this.signin = signin;
  }

  @Override
  public void execute() {
      // 파일입출력 기능의 정상작동 확인을 위한 테스트 코드(2 Lines)
      //signin.readfile();
      signin.auth("test01", "test002");
  }

}
