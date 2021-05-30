/*
Client.java
- Proxy 패턴의 Client의 역할을 수행
 */
package proxy;

import command.Signin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Jiwon
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            /* Test Code
            - 파일명을 Parameter로 넘김.
            - 추후 사용자 입력 받을(검색 정보) 내용은 받도록 구현 예정
            */
            
            // 로그인된 사용자 id값을 가져옴 - 추후 대안 검토
            // String userid = Signin.sessionid;
            String userid = "test001";  // 사용자 test001이 로그인했다고 가정
            
            // 사용자 선택값을 입력받기 위한 표준입력함수 호출
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            int storeid = 0;    // 시설 id
            int date = 0;   // 확인하려는 날짜
        
        try {
            
            // 사용자로부터 시설 id와 날짜를 입력받는다.
            System.out.print("시설 id : ");
            storeid = Integer.parseInt(br.readLine());
            
            System.out.print("날짜 : ");
            date = Integer.parseInt(br.readLine());
            
            // List list = new Proxy("test001_1_20210531.txt");
            
            List list = new Proxy(userid + "_" + storeid + "_" + date + ".txt");
            list.displayList();
            
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }
    
}
