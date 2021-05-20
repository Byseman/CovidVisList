/*
Signout.java
- Command 패턴의 요소인 Receiver 객체에 해당
- 로그인에 대한 처리를 담당
*/

package command;

public class Signout {
  
// 로그아웃 기능의 정상작동 확인을 위한 확인용 코드 - BoUML 미적용
  public Signout(){}
  
// 로그아웃을 진행하기 위한 메소드 - BoUML 미적용
  public void signoutsrv(){
      Signin.sessionid = "";
      System.out.println("----------------------------------------------");
      System.out.println("로그아웃 되었습니다!");
  }
  
  // 로그인 여부를 확인하기 위한 테스트 메소드 - BoUML 미적용
  /* public void chksignin(String userid){
      // 현재 로그인되어있는 계정 정보를 받아옴
      String tempid = Signin.sessionid;
      
      if(tempid.equals(userid)){
          System.out.println("현재 " + userid + "님이 로그인 되어 있습니다.");
      }
      
      else{
          System.out.println("현재 로그인이 되어있지 않습니다.");
      }
  }*/
}
