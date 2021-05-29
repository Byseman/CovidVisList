/*
ExistingManagerRegister.java
- Strategy 패턴
- RegisterBehavior.java(interface)를 상속 / 행동 클래스
- 기존 사업자의 사업자등록정보를 받음.
*/
package strategy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class ExistingManagerRegister implements RegisterBehavior {
    
    protected String facilityName;
    protected String licenseNum;
    protected String presidentName;
    protected String facilityNum;
    protected String businessType;
    protected String facilityZone;
    protected String facilityAddress;

    public ExistingManagerRegister(String facilityName, String licenseNum, String presidentName, String facilityNum, String businessType, String facilityZone, String facilityAddress) {
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
              System.out.println("----------사업자등록정보(기존)---------------");
              System.out.println("----------------------------------------------");
        
        try {
            outFile(); // 데이터를 리스트에 저장
        } catch (IOException ex) {
            Logger.getLogger(NewManagerRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        boolean check[] = new boolean[3]; // 기존에 있던 사업자 등록정보와 일치 여부 저장
        
        System.out.println("               *사업자 정보 확인*");
        System.out.println("사업자 등록번호와 대표자명을 입력해주세요.");
        System.out.println("----------------------------------------------");
        // 기존에 있던 사업자 등록번호와 대표자명이 입력받은 값과 일치할 때까지 반복
        do{
            check[0] = inLNum(); // 사업자 등록번호 입력받음
            check[1] = inPName(); // 대표자명을 입력받음
        }while (check[0] == false || check[1] == false);
        System.out.println("----------------------------------------------");

        System.out.println("사업자 정보가 확인되었습니다.");
        inFName(); // 상호명을 입력받음

        System.out.println("사업장 전화번호는 다음과 같이 입력해주세요.");
        System.out.println("ex)01012341234");
        do{
            check[2] = inFNum(); // 사업장 전화번호를 입력받음
        }while (check[2] == false); // 형식에 일치할 때까지 반복
        
        inBType(); // 업종을 입력받음
        inFZone(); // 관할지역을 입력받음
        inFAddress(); //사업장 주소를 입력받음
        
        System.out.println("성공적으로 등록되었습니다.");
        String info; // 사업자 등록정보를 저장
        info = facilityName + '/' + licenseNum + '/' + presidentName + '/' 
                + facilityNum + '/' + businessType + '/' + facilityZone + '/' + facilityAddress;
        inFile(info); // 사업자 등록정보를 파일에 저장
        
    }

    
    abstract void inFName();
    abstract boolean inLNum();
    abstract boolean inPName();
    abstract boolean inFNum();
    abstract void inBType();
    abstract void inFZone();
    abstract void inFAddress();
    abstract void inFile(String info);
    abstract void outFile() throws IOException;
}
