/*
Signup.java
- Command 패턴의 요소인 Receiver 객체에 해당
- 로그인에 대한 처리를 담당
- builder패턴이 적용된 회원가입 기능 구현 후 통합 시 연결
*/

package command;

public class Signup {
  private String userid;
  private String password;
  private String tel;
  
  // 회원가입 기능의 정상작동 확인을 위한 확인용 코드 - 필요 시 BoUML에 적용
  public Signup(){}

  public Signup(String userid, String password, String tel) {
      this.userid = userid;
      this.password = password;
      this.tel = tel;
  }
  
  public void signupsrv(){
      System.out.println("----------------------------------------------");
      System.out.println("준비중입니다.");
  }

}
