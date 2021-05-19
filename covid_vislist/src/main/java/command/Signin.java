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
  
  // 파일로부터 계정 Parsing을 위한 인스턴스 변수 - BoUML미적용
  private ArrayList<String> idpw = new ArrayList<String>();
  
  // 파일입출력 기능의 정상작동 확인을 위한 확인용 코드 - 필요 시 BoUML에 적용
  public Signin(){}

  public Signin(String userid, String password) {
      this.userid = userid;
      this.password = password;
  }

  // 개요 : 로그인 시 회원으로 등록되어 있는지 여부를 판단하는 데이터를 불러옴.
  // ArrayList를 반환하기 위해 메소드 반환형 변경
  public ArrayList<String> readfile(ArrayList<String> idpw){
  //public void readfile() {
      try{
          File file = new File("./datafile/member.txt");
          
          // 한글 깨짐 현상이 발생되어 인코딩 형식을 지정함으로서 문제가 해결됨.
          BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
          
          // 파일을 읽어들이기 위해 필요한 인스턴스 변수 생성(2 Lines)
          String temp = "";
          String[] splittemp = null;
          
          while((temp = br.readLine()) != null){              
              // id, pw만 받아오기 위한 split 사용
              splittemp = temp.split(" ");
              for(int i = 0; i < splittemp.length; i++){
                  splittemp[i] = splittemp[i].trim();
                  
                  // 가공된 List에 추가
                  idpw.add(splittemp[i]);
                  
                  // 임시배열에 split되어 잘 저장되었는지 확인하기 위한 테스트 코드
                 // System.out.println("(TEST) " + splittemp[i]);
              }
          }
          // 파일을 다 읽었다면 닫아줘야함.
          br.close();
          
          // 동적리스트에 저장이 정상적으로 되었는지 확인하기 위한 테스트 코드
          // (20 Lines)
          /*
          int lenofElements = idpw.size();

          for(int i = 0; i < lenofElements; i++){
              if((i*3) < lenofElements){
                for(int j = (i * 3); j < ((i * 3) + 3); j++){
                    System.out.println(idpw.get(j));
                
                    // List의 Size 크기만큼 반복하여
                    // 모든 값이 잘 저장되어 있는지 확인하기 위한 테스트 코드
                    //System.out.println("(TEST) " + i + " : " + idpw.get(i));
                }
              }
              
              else
                  break;
              
            System.out.println();
         }
          */
      }catch(IOException e){
          e.getStackTrace();
      }
      
      // 가공되어 저장된 ArrayList 반환
      return (idpw);
  }
  
  // 로그인 하려는 사용자로부터 정보를 받아 저장하는 메소드 추가 - BoUML 미적용
  public void auth(String userid, String password){
  
  // 값을 잘 받아오는지 여부를 확인하기 위한 테스트 코드
  // public void auth(){
      ArrayList<String> acclist = new ArrayList<String>();
      readfile(acclist);
      
      // 받아온 값이 동적리스트에 저장이 정상적으로 되었는지 확인하기 위한 테스트 코드
      // (20 Lines)
          /*
          int lenofElements = acclist.size();

          for(int i = 0; i < lenofElements; i++){
              if((i*3) < lenofElements){
                for(int j = (i * 3); j < ((i * 3) + 3); j++){
                    System.out.println(acclist.get(j));
                
                    // List의 Size 크기만큼 반복하여
                    // 모든 값이 잘 저장되어 있는지 확인하기 위한 테스트 코드
                    //System.out.println("(TEST) " + i + " : " + idpw.get(i));
                }
              }
              
              else
                  break;
              
            System.out.println();
         }
          */
      
      // 사용자로부터 id, pw를 입력받은 후 정보가 있는지 비교 시 반환되는 값을
      // 확인하기 위한 테스트 코드(이하 전체 Lines)
      if(acclist.contains(userid)){
          System.out.println("아이디 검증 성공 - index값 : " + acclist.indexOf(userid));
          // 아이디 검증 후 비밀번호 일치여부를 확인
          if(password.equals(acclist.get((acclist.indexOf(userid))+1))){
              System.out.println("비밀번호 검증 성공");
              System.out.println(acclist.get(acclist.indexOf(userid)+2) + "님, 환영합니다.");
          }
          
          else{
             System.out.println("비밀번호 검증 실패"); 
          }
      }
      
      else{
          System.out.println("로그인 실패");
      }
      
  }
  
  // 사용자로부터 정보를 입력받는 메소드 생성 - BoUML 미적용
  /*public void inputvalue(){
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      String userid = br.readLine();
      
      
      
  }*/

}
