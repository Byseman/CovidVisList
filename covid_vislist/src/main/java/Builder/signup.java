/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder;

/**
 *
 * @author Owner
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class signup {
    File file = new File("signup.txt");
    FileWriter write = null;
    String temp=" ";
    Scanner sc = new Scanner(System.in);
        
    try{
        Scanner sc = new Scanner(System.in);
        String ID;
        String PW;  
        int infocheck;
        System.out.println("이용약관, 개인정보처리방침을 확인합니다. \n숫자를 입력해주세요(1=동의,0=거절)");
        infocheck=sc.nextInt();
     
        if(infocheck==1){
            System.out.println("이용약관, 개인정보처리방침에 동의하셨습니다.");
         
            System.out.println("아이디를 입력해주세요.");      ID=sc.next();
            System.out.println("비밀번호를 입력해주세요.");     PW=sc.next();
                write = new FileWriter(file,true); //true = 기존 파일 내용 끝에 데이터를 추가할 경우
                write.write(ID);
                write.write(temp);
                write.write(PW);
                write.flush();// 출력은 버퍼에 쌓여있기에 쌓인 버퍼를 목적지로 보내줌
            
                pw_check pw_check=new pw_check();//비밀번호 확인 코드

    } else{
    System.exit(0);
    System.out.println("이용약관, 개인정보처리방침에 거절하셨습니다\n 회원가입을 종료합니다.");
    }
     
    }catch(IOException e){
    e.printStackTrace();
    }
}
