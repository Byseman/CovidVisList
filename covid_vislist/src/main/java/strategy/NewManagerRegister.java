/*
NewManagerRegister.java
- Strategy 패턴
- RegisterBehavior.java(interface)를 상속 / 행동 클래스
- 새로운 사업자의 사업자등록정보를 받음.
*/
package strategy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class NewManagerRegister implements RegisterBehavior {

    protected String facilityName;
    protected String licenseNum;
    protected String presidentName;
    protected String facilityNum;
    protected String businessType;
    protected String facilityZone;
    protected String facilityAddress;

    public NewManagerRegister(String facilityName, String licenseNum, String presidentName, String facilityNum, String businessType, String facilityZone, String facilityAddress) {
        this.facilityName = facilityName;
        this.licenseNum = licenseNum;
        this.presidentName = presidentName;
        this.facilityNum = facilityNum;
        this.businessType = businessType;
        this.facilityZone = facilityZone;
        this.facilityAddress = facilityAddress;
    }
    
    @Override
    public void register() {
        System.out.println("----------------------------------------------");
        System.out.println("----------사업자등록정보(신규)---------------");
        System.out.println("----------------------------------------------");
        try {
            boolean check = false; // 사업장 전화번호의 형식 일치
            
            try {
                outFile(); // 데이터를 리스트에 저장
            } catch (IOException ex) {
                Logger.getLogger(NewManagerRegister.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            inFName(); // 상호명을 입력받음
            inLNum(); // 사업자 등록번호를 입력받음
            inPName(); // 대표자를 입력받음
            
            System.out.println("사업장 전화번호는 다음과 같이 입력해주세요.");
            System.out.println("ex)01012341234");
            do{
                check = inFNum();
            }while (check == false);  // 사업장 전화번호의 형식이 일치할 때까지 받음
            
            inBType(); // 업종을 입력받음
            inFZone(); // 관할 지역을 입력받음
            inFAddress(); // 사업장 주소를 입력받음
            
           System.out.println("성공적으로 등록되었습니다.");
            String info; // 사업자 등록정보를 저장
            info = facilityName + '/' + licenseNum + '/' + presidentName + '/'
                    + facilityNum + '/' + businessType + '/' + facilityZone + '/' + facilityAddress;
            inFile(info); // 사업자 등록정보를 파일에 저장
        } catch (IOException ex) {
            Logger.getLogger(NewManagerRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    abstract void inFName();

    abstract void inLNum();

    abstract void inPName();

    abstract boolean inFNum();

    abstract void inBType();

    abstract void inFZone();

    abstract void inFAddress();
    
    abstract void inFile(String info) throws IOException;
    
    abstract void outFile() throws IOException;
}