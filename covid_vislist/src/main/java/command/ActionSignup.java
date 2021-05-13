/*
ActionSignup.java
- Command 패턴의 요소인 ConcreteCommand 객체에 해당
*/

package command;

public class ActionSignup implements ActionListenerCommand {
  private Signup signup;

  public ActionSignup(Signup signup) {
      this.signup = signup;
  }

  @Override
  public void execute() {
  }

}
