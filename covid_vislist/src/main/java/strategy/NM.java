/*
NM.java
- Strategy 패턴
- NewManagerRegister.java를 상속하여 세부적인 기능 수행
- 새로운 사업자등록정보를 입력받음.
*/
package strategy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

class NM extends NewManagerRegister{
    
    private ArrayList<String> readInfo = new ArrayList<>(); //텍스트 파일로 읽어들인 사업자등록정보를 String 형식으로 담음
    private ArrayList<NM> managerInfo = new ArrayList<>(); //텍스트 파일로 내보낼 사업자등록정보
    
    public NM(String facilityName, String licenseNum, String presidentName, String facilityNum, String businessType, String facilityZone, String facilityAddress) {
        super(facilityName, licenseNum, presidentName, facilityNum, businessType, facilityZone, facilityAddress);
    }
    
    Scanner sc = new Scanner(System.in);
    
    protected void inFName() {
        
        String input;
        int check = 0; //상호명 존재 여부
        
        System.out.print("상호명:");
        input = sc.next();
        
        /*
         새로운 사업자등록정보
         -> 기존 상호명과 일치하는 시설을 등록할 수 없다.
        */
        for (NM info:managerInfo) {
            if (info.facilityName.equals(input)) {
                check = 1; //기존 상호명과 일치
            }
        }
        if(check == 0){ //기존 상호명과 일치하지 않아 입력받은 값 저장
            this.facilityName = input;
        }
        else { //기존 상호명과 일치하여 다시 상호명을 입력받음
            System.out.println("이미 존재하는 시설입니다.");
            inFName();
        }
    }
    
    protected void inLNum() {
        String input;
        int check = 0; //사업자 등록번호 존재 여부
        
        System.out.print("사업자 등록번호:");
        input = sc.next();
        
        
        /*
         새로운 사업자등록정보
         -> 기존 사업자 등록번호와 일치하는 사업자 등록번호는 등록할 수 없다.
        */
        for (NM info:managerInfo) {
            if (info.licenseNum.equals(input)) {
                check = 1; // 기존 사업자 등록번호와 일치
            }
        }
        if(check == 0){ //기존 사업자 등록번호와 일치하지 않아 값 저장
            this.licenseNum = input;
        }
        else { // 기존 사업자 등록번호와 일치하여 다시 입력받음
            System.out.println("이미 존재하는 사업자 등록번호입니다.");
            inFName();
        }
    }
    protected void inPName(){
        // 대표자명을 입력받음
        System.out.print("대표자명:");
        this.presidentName = sc.next();
        
    }
    protected boolean inFNum(){
        //사업장 전화번호를 입력받음
        String num;
        System.out.print("사업장 전화번호:");
        num = sc.next();
        
        //사업장 전화번호에 형식 적용
        // ex) 01012341234
        String numPattern = "^\\d{11}$";
        if(Pattern.matches(numPattern, num)) {
            this.facilityNum = num;  // 형식이 일치할 경우에만 값 저장
            return true;
        } else {       
            // 형식이 일치하지 않아 다시 입력 받음
            System.out.println("올바른 휴대전화 형식이 아닙니다. ");
            return false;
        }
    }
    protected void inBType(){
        // 업종을 입력받음
        System.out.print("업종:");
        this.businessType = sc.next();

    }
    protected void inFZone(){
        // 관할 지역을 입력받음
        System.out.print("관할지역:");
        this.facilityZone = sc.next();
    }
    
    protected void inFAddress(){
        String input;
        int check = 0; //사업장 주소 존재 여부
        
        System.out.print("사업장 주소:");     
        input = sc.next();
        
        /*
         새로운 사업자등록정보
         -> 기존 사업장 주소와 일치할 경우 등록할 수 없다.
        */
        for (NM info:managerInfo) {
            if (info.facilityAddress.equals(input)) {
                check = 1; //기존 사업장 주소와 일치
            }
        }
        if(check == 0){
            // 기존 사업장 주소와 일치하지 않을 경우 값 저장
            this.facilityAddress = input;
        }
        else {
            // 기존 사업장 주소와 일치하여 다시 값을 입력 받음
            System.out.println("이미 존재하는 사업자 주소입니다.");
            inFAddress();
        }
    }
    
    protected void inFile(String info){
        // 입력받은 사업장 등록정보를 파일에 저장
        BufferedWriter bf = null;
        try {
            bf = new BufferedWriter(new FileWriter("manager.txt", true));
            PrintWriter pw = new PrintWriter(bf, true);
            pw.write(info + "\n");
            pw.flush();
            pw.close();
        } catch (IOException ex) {
            Logger.getLogger(NewManagerRegister.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bf.close();
            } catch (IOException ex) {
                Logger.getLogger(NewManagerRegister.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    } 
    
    protected void outFile() throws IOException {
        // 기존에 있던 사업자등록정보를 읽어 리스트 형식으로 저장
        String line;
         File file = new File("manager.txt");
        try {
          BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)/*, "utf-8"*/));
            while ((line = br.readLine()) != null) {
                readInfo.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
                    
        for (String info: readInfo) {
            line = info;
            String[] str = line.split("/");
            System.out.println(str[0]);
            managerInfo.add(new NM(str[0], str[1], str[2], str[3], str[4], str[5], str[6]));
        }
    }
}

