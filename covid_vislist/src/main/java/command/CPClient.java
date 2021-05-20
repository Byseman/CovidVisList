/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Jiwon
 */
public class CPClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        try{
            // Receiver 호출
            Signup signup = new Signup();
            Signin signin = new Signin();
            Signout signout = new Signout();

            // Concrete Command 호출
            ActionListenerCommand signupCommand = new ActionSignup(signup);
            ActionListenerCommand signinCommand = new ActionSignin(signin);
            ActionListenerCommand signoutCommand = new ActionSignout(signout);

            // Invoker 호출
            MenuOptions menu = new MenuOptions(signupCommand, signinCommand, signoutCommand);

            // 로그인 세션으로 활용하기 위한 인스턴스 변수(1 Line - 아래로 위치 변경)
            // String test = Signin.sessionid;
            // String test = "";

            // 사용자 선택값에 대해 값을 저장할 필요가 있음.
            int menunum = 0;

            // 사용자 선택값을 입력받기 위한 표준입력함수 호출
            // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Scanner sc = new Scanner(System.in);

            // 사용자 선택을 위한 메뉴화면 구현
            while(true){
                // 로그인 세션으로 활용하기 위한 인스턴스 변수
                // String test = Signin.sessionid;

                System.out.println("----------------------------------------------");
                System.out.println("----------COVID-19 출입명부 프로그램----------");
                System.out.println("----------------------------------------------");
                System.out.println("1. 회원가입");
                System.out.println("2. 로그인");

                /*if(test.equals("")){
                    System.out.println("3. 프로그램 종료");
                }

                else{
                    System.out.println("3. 로그아웃");
                    System.out.println("4. 프로그램 종료");
                }*/

                System.out.println("3. 프로그램 종료");

                System.out.println("----------------------------------------------");
                System.out.print("메뉴 선택 : ");

                menunum = sc.nextInt();
                // menunum = br.read();

                switch(menunum){
                    case 1 :
                        menu.selsignup();
                        break;

                    case 2 :
                        menu.selsignin();
                        break;

                    case 3 :
                        System.out.println("----------------------------------------------");
                        System.out.println("프로그램을 종료합니다.");
                        System.exit(0);

                        /*
                        if(test.equals("")){
                            System.out.println("----------------------------------------------");
                            System.out.println("프로그램을 종료합니다.");
                            System.exit(0);
                        }

                        else{
                            menu.selsignout();
                            break;
                        }

                    case 4 :
                        System.out.println("----------------------------------------------");
                        System.out.println("프로그램을 종료합니다.");
                        System.exit(0);
                        */

                    default :
                        System.out.println("----------------------------------------------");
                        System.out.println("잘못 입력하셨습니다.");
                        System.out.println("다시 입력해주세요.");
                }
            } 
        } catch(Exception ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage()); 
     }
        
        // 파일입출력 기능의 정상작동 확인을 위한 테스트 코드
        /*Signin signin = new Signin();
        ActionListenerCommand signinCommand = new ActionSignin(signin);
        MenuOptions menuoptions = new MenuOptions();
        menuoptions.setCommand(signinCommand);
        menuoptions.select();*/
        
                
        // 로그아웃 기능의 정상작동 확인을 위한 테스트 코드(이하 전체 Line)
        /*Signout signout = new Signout();
        ActionListenerCommand signoutCommand = new ActionSignout(signout);
        MenuOptions menuoptions = new MenuOptions();
        menuoptions.setCommand(signoutCommand);
        menuoptions.select();*/
    }
    
}
