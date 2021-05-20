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
  private String userid = "";

  private String password = "";
  
  // 로그인이 되어있는지 여부를 확인하기 위한 테스트 코드(1 Line)
  // public static String sessionid = "";
  
  // 파일로부터 계정 Parsing을 위한 인스턴스 변수 - BoUML미적용
  private ArrayList<String> idpw = new ArrayList<String>();
  
  // 사용자 로그인 정보를 저장하기 위한 인스턴스 변수 - BoUML 미적용
  private String username;
  
  // 파일입출력 기능의 정상작동 확인을 위한 확인용 코드 - 필요 시 BoUML에 적용
  public Signin(){}

  public Signin(String userid, String password) {
      this.userid = userid;
      this.password = password;
  }
  
  // 사용자의 입력을 받음. - BoUML미적용
  public void signinsrv() throws IOException {
  // public String signinsrv() throws IOException {
      try{
          // 입출력 시 자원 효율 고려하여 BufferedReader 사용함.
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          boolean result;

          // 2 Lines for Test(관련 주석 : 사용자 화면에 비밀번호 입력값...)
          // Console cs = System.console();
          // char[] pw;

          while(true){
              System.out.println("----------------------------------------------");
              System.out.println("--------------------LOGIN---------------------");
              System.out.println("----------------------------------------------");
              System.out.print("아이디 : ");
              userid = br.readLine();

              // userid = sc.nextLine();
              System.out.print("비밀번호 : ");
              password = br.readLine();

              // 사용자 화면에 비밀번호 입력값이 표시가 안되는지 확인하기 위한 테스트 코드
              // (2 Lines)
              // pw = cs.readPassword("비밀번호 : ");
              // password = new String(pw); 

              result = auth(userid, password);

              if(result){
                  System.out.println(username + "님 환영합니다!");
                  // sessionid = userid;
                  // 이후 넘어갈 페이지 구현 후 통합 시 연결
                  break;
              }

              else{
                  System.out.println("ID 또는 비밀번호가 일치하지 않습니다.");
              }
          }
      } catch(IOException ex){
          ex.printStackTrace();
          System.out.println(ex.getMessage());
      }
      // return userid;
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
  
  // 사용자 인증 메소드의 반환값을 Boolean으로 변경하여 정상 동작하는지 확인을 위한
  // 메소드 형변환
    public boolean auth(String userid, String password){
  
  // 로그인 하려는 사용자로부터 정보를 받아 저장하는 메소드 추가 - BoUML 미적용
  // public void auth(String userid, String password){
  
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
          // System.out.println("아이디 검증 성공 - index값 : " + acclist.indexOf(userid));
          // 아이디 검증 후 비밀번호 일치여부를 확인
          if(password.equals(acclist.get((acclist.indexOf(userid))+1))){
              // System.out.println("비밀번호 검증 성공");
              // signinsrv 메소드에서 아래 1줄 활용
              // System.out.println(acclist.get(acclist.indexOf(userid)+2) + "님, 환영합니다.");
              username = acclist.get(acclist.indexOf(userid)+2);
              return true;
          }
          
          else{
             // System.out.println("비밀번호 검증 실패");
             return false;
          }
      }
      
      else{
          // System.out.println("로그인 실패");
          return false;
      }
      
  }
  
  // 사용자로부터 정보를 입력받는 메소드 생성 - BoUML 미적용
  /*public void inputvalue(){
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      String userid = br.readLine();
      
      
      
  }*/

}
