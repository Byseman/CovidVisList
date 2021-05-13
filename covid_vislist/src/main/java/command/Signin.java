/*
Signin.java
- Command 패턴의 요소인 Receiver 객체에 해당
- 로그인에 대한 처리를 담당
*/

package command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Signin {
  private String userid;

  private String password;
  
  // 파일로부터 계정 Parsing을 위한 인스턴스변수 - BoUML미적용
  private ArrayList<String> idpw = new ArrayList<String>();
  
  // 파일입출력 기능의 정상작동 확인을 위한 확인용 코드 - 필요 시 BoUML에 적용
  public Signin(){}

  public Signin(String userid, String password) {
      this.userid = userid;
      this.password = password;
  }

  // 로그인 시 회원으로 등록되어 있는지 여부를 판단하는 데이터를 불러옴.
  public void readfile() {
      try{
          File file = new File("./datafile/member.txt");
          // 한글 깨짐 현상이 발생되어 인코딩 형식을 지정함으로서 문제가 해결됨.
          BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
          // 파일을 읽어들이기 위해 필요한 인스턴스 변수 생성
          String temp = "";
          
          while((temp = br.readLine()) != null){
              // 파일을 정상적으로 읽어왔는지 확인하기 위한 테스트 코드
              //System.out.println(temp);
              // 파일을 읽어와 동적리스트에 저장
              idpw.add(temp);
          }
          // 파일을 다 읽었다면 닫아줘야함.
          br.close();
          
          // 동적리스트에 저장이 정상적으로 되었는지 확인하기 위한 테스트코드
          // (3 Lines)
          int lenofElements = idpw.size();
          for(int idx = 0; idx < lenofElements; idx++){
              System.out.println(idpw.get(idx));
          }
    
      }catch(IOException e){
          e.getStackTrace();
      }
  }

}
