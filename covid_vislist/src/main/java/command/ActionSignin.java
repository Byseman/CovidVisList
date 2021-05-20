/*
ActionSignin.java
- Command 패턴의 요소인 ConcreteCommand 객체에 해당
*/

package command;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ActionSignin implements ActionListenerCommand {
  private Signin signin;

  public ActionSignin(Signin signin) {
      this.signin = signin;
  }

  @Override
  public void execute() {
      try {
          // 파일입출력 기능의 정상작동 확인을 위한 테스트 코드(1 Line)
          //signin.readfile();
          
          signin.signinsrv();
          
          // userid를 잘 받아오는지 위한 테스트 코드(2 Lines)
          // String test = signin.signinsrv();
          // System.out.print(test + "님이 로그인 했습니다.");
          
          // 반환형 변경 후 정상 작동하는지 확인하기 위한 테스트 코드(이하 전체 Lines)
          // boolean test = signin.auth("test001", "test002");
          // System.out.println(test);
      } catch (IOException ex) {
          Logger.getLogger(ActionSignin.class.getName()).log(Level.SEVERE, null, ex);
      }
  }

}
