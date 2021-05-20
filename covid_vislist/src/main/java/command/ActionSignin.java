/*
ActionSignin.java
- Command 패턴의 요소인 ConcreteCommand 객체에 해당
*/

package command;

import java.io.IOException;

public class ActionSignin implements ActionListenerCommand {
  private Signin signin;

  public ActionSignin(Signin signin) {
      this.signin = signin;
  }

  @Override
  public void execute() {
      try {
          signin.signinsrv();
      } catch (IOException ex) {
          ex.printStackTrace();
          System.out.println(ex.getMessage());
      } finally{
          
      }
  }

}
