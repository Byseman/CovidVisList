/*
ActionSignout.java
- Command 패턴의 요소인 ConcreteCommand 객체에 해당
*/

package command;

public class ActionSignout implements ActionListenerCommand {
  private Signout signout;

  public ActionSignout(Signout signout) {
      this.signout = signout;
  }

  @Override
  public void execute() {
      signout.signoutsrv();
  }

}
