/*
MenuOptions.java
- Command 패턴의 요소인 Invoker 객체에 해당
- 회원가입, 로그인, 로그아웃 기능의 명령을 받아 수행
*/
package command;

public class MenuOptions {
  private ActionListenerCommand ActionSignup;   // 회원가입
  private ActionListenerCommand ActionSignin;   // 로그인
  private ActionListenerCommand ActionSignout;  // 로그아웃
  
  // BoUML 미적용
  public MenuOptions(ActionListenerCommand aSignup, ActionListenerCommand aSignin, ActionListenerCommand aSignuout) {
      this.ActionSignup = aSignup;
      this.ActionSignin = aSignin;
      this.ActionSignout = aSignuout;
  }

  public void selsignup() {
      ActionSignup.execute();
  }
  
    public void selsignin() {
      ActionSignin.execute();
  }
    
    public void selsignout() {
      ActionSignout.execute();
  }
}
