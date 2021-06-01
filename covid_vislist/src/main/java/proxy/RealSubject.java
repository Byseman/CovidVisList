/**
 RealSubject.java
 - Proxy 패턴의 RealSubject 역할
 */
package proxy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class RealSubject implements List {

    private ArrayList<String> list = new ArrayList<>();
    private String filename;

    public RealSubject(String filename) {
        this.filename = filename;
        LoadList(filename); // 생성자에서 파일을 읽어오는 메소드 추가
    }


    
    // LoadList 개요 : Command 패턴 내 Signin.readfile 메소드 코드 재사용
    /**
     * 파일 로딩.
     * 파일 이름을 입력받아 해당 파일의 출입 명부를 불러옴
     * @param filename 
     */
    private void LoadList(String filename) {
        System.out.println("파일 로딩 중");
        // list에 코드 넣기 (리스트 한 줄 형식으로 저장 원합니다~!~)
        // ㄴ Re : 반영하겠습니다~^^
        
        // 파일
        File file = new File("./datafile/" + filename);
        
        // 파일을 읽어들이기 위해 필요한 인스턴스 변수 생성(2 Lines)
        String temp = "";
        String[] splittemp = null;
        
        try {           
            // 한글 깨짐 현상이 발생되어 인코딩 형식을 지정함으로서 문제가 해결됨.
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));

            while((temp = br.readLine()) != null){              
                    // 가공된 List에 추가
                    list.add(temp);

                    // 임시배열에 split되어 잘 저장되었는지 확인하기 위한 테스트 코드
                    // System.out.println("(TEST) " + temp);
            }
            
          // 파일을 다 읽었다면 닫아줘야함.
          br.close();
            
        } catch(IOException e){
          e.getStackTrace();
      }
    }

    /**
     * 출입명부를 화면에 출력.
     * 명부가 존재하지 않을 시 출입명부가 존재하지 않는다는 에러 메시지를 띄움
     * 명부가 존재할 시 출입명부를 화면에 출력함
     */
    @Override
    public void displayList() {
        if (list.get(0) == null) {
            System.out.println("출입명부가 존재하지 않습니다.");
        } else {
            for (String list : list) {
                System.out.println(list);
            }
        }
    }
}
