/*
EM.java
- Strategy 패턴
- ExistingManagerRegister.java를 상속받아 세부적인 기능 수행
- 기존 사업자의 사업자등록정보를 받음.
 */
package strategy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

class EM extends ExistingManagerRegister {

    private ArrayList<String> readInfo = new ArrayList<>();  //텍스트 파일로 읽어들인 사업자등록정보를 String 형식으로 담음
    private ArrayList<EM> managerInfo = new ArrayList<>();  //텍스트 파일로 내보낼 사업자등록정보

    public EM(String facilityName, String licenseNum, String presidentName, String facilityNum, String businessType, String facilityZone, String facilityAddress) {
        super(facilityName, licenseNum, presidentName, facilityNum, businessType, facilityZone, facilityAddress);
    }

    /**
     * 상호명을 입력 받음. 
     * 상호명이 존재하지 않을 경우 상호명을 입력받음. 상호명이 존재할 경우 상호명을 다시 입력받음.
     */
    protected void inFName() {

        String input;
        int check = 0; //상호명 존재 여부(상호명은 00상호명(5층)처럼 구체적)

        Scanner sc = new Scanner(System.in);
        System.out.print("상호명:");
        input = sc.next();

        /*
         기존 대표자
         -> 상호명이 일치하는 시설을 등록할 수 없다.
         */
        for (EM info : managerInfo) {
            if (info.presidentName.equals(this.presidentName)) {
                if (info.facilityName.equals(input)) {
                    check = 1; //대표자, 상호명 일치
                }
            }
        }

        if (check == 0) { //새로운 상호명일 경우 입력받은 상호명 저장
            this.facilityName = input;
        } else { // 상호명 일치하면 존재하는 시설이므로 다시 상호명 입력
            System.out.println("이미 존재하는 시설입니다.");
            inFName();
        }

    }

    /**
     * 기존 사업자 확인을 위해 사업자 등록번호를 입력받음. 
     * 사업자 등록번호가 일치할 때까지 입력받음. 사업자 등록번호가 일치하지 않을 경우 다시 입력받음.
     *
     * @return 사업자 등록번호 일치 여부(일치할 경우 true, 일치하지 않을 경우 false)
     */
    protected boolean inLNum() {

        String input;
        int check = 0; //사업자 등록번호 존재 여부

        Scanner sc = new Scanner(System.in);
        System.out.print("사업자 등록번호:");
        input = sc.next();

        /*
        기존 사업자등록정보
        -> 사업자 등록번호와 대표자명이 일치하는지 확인
        -> 다른 정보 입력받음
         */
        for (EM info : managerInfo) {
            if (info.licenseNum.equals(input)) {
                check = 1; //사업자 등록번호 일치
            }
        }

        //대표자명과 사업자등록정보 둘 다 일치하는지 확인하기 위해 리턴값을 가짐
        if (check == 0) {
            // 사업자 등록번호가 일치하지 않을시 다시 입력
            return false;
        } else { //사업자 등록번호가 일치하면 값 저장
            this.licenseNum = input;
            return true;
        }

    }

    /**
     * 기존 사업자 확인을 위해 대표자명을 입력받음. 
     * 대표자명이 일치할 때가지 입력받음. 
     * 대표자가 일치하지 않을 경우 다시 입력받음.
     * 
     * @return 대표자명 일치 여부(일치할 경우 true, 일치하지 않을 경우 false)
     */
    protected boolean inPName() {

        String input;
        int check = 0; //대표자명 존재 여부

        Scanner sc = new Scanner(System.in);
        System.out.print("대표자명:");
        input = sc.next();

        /*
        기존 사업자등록정보
        -> 사업자 등록번호와 대표자명이 일치하는지 확인
        -> 다른 정보 입력받음
         */
        for (EM info : managerInfo) {
            if (info.presidentName.equals(input)) {
                check = 1; // 기존 대표자와 대표자명 일치
            }
        }

        //대표자명과 사업자등록정보 둘 다 일치하는지 확인하기 위해 리턴값을 가짐
        if (check == 0) { // 기존 대표자와 입력한 대표자명이 일치x
            System.out.println("등록되지 않은 시설이거나 사업자등록번호, 대표자명이 일치하지 않습니다.");
            return false;
        } else { //기존 대표자와 입력한 대표자명이 일치
            this.presidentName = input; //입력받은 대표자명 저장
            return true;
        }

    }

    /**
     * 사업장 전화번호를 입력받음. 
     * 입력 형식과 일치할 때까지 전화번호를 입력받음. 
     * 입력 형식과 일치하지 않을 경우 전화번호를 다시 입력받음.
     * 
     * @return 전화번호 패턴 일치 여부(일치할 경우 true, 일치하지 않을 경우 false)
     */
    protected boolean inFNum() {

        String num;

        Scanner sc = new Scanner(System.in);
        System.out.print("사업장 전화번호:");
        num = sc.next();

        //전화번호를 입력받을 시 패턴 일치 확인
        //ex) 01012341234
        String numPattern = "^\\d{11}$";

        if (Pattern.matches(numPattern, num)) {
            this.facilityNum = num;  //패턴이 일치할 경우 값 저장        
            return true;
        } else {  //패턴이 일치하지 않을 경우 값을 다시 받기 위해 false 리턴
            System.out.println("올바른 휴대전화 형식이 아닙니다. ");
            return false;
        }
    }

    /**
     * 업종을 입력받음.
     */
    protected void inBType() {

        Scanner sc = new Scanner(System.in);
        System.out.print("업종:");
        this.businessType = sc.next();

    }

    /**
     * 관할지역을 입력받음.
     */
    protected void inFZone() {

        Scanner sc = new Scanner(System.in);
        System.out.print("관할지역:");
        this.facilityZone = sc.next();
    }

    /**
     * 사업장 주소를 입력받음. 
     * 사업장 주소가 존재하지 않을 경우 값을 저장 사업장 주소가 존재할 경우 다시 입력받음.
     */
    protected void inFAddress() {

        String input;
        int check = 0; //사업장 주소 존재 여부
        Scanner sc = new Scanner(System.in);
        System.out.print("사업장 주소:");
        input = sc.next();

        /*
        기존 사업자등록정보
        -> 사업장 주소가 다 달라야 함
         */
        for (EM info : managerInfo) {
            if (info.presidentName.equals(this.presidentName)) {
                if (info.facilityAddress.equals(input)) {
                    check = 1; // 기존 대표자가 등록한 사업장 주소와 일치
                }
            }
        }

        if (check == 0) {
            //기존 대표자가 등록한 사업장 주소와 일치하지 않을 경우 값 저장
            this.facilityAddress = input;
        } else {
            // 기존 대표자가 등록한 사업장 주소와 일치할 경우 다시 사업장 주소를 입력받음
            System.out.println("이미 존재하는 시설입니다.");
            inFAddress();
        }
    }

    /**
     * 입력받은 사업장 등록정보를 파일에 저장
     *
     * @param info
     */
    protected void inFile(String info) {
        // 입력받은 사업장 등록정보를 파일에 저장
        BufferedWriter bf = null;
        try {
            bf = new BufferedWriter(new FileWriter("./datafile/manager.txt", true));
            PrintWriter pw = new PrintWriter(bf, true);
            pw.write(info + "\n");
            pw.flush();
            pw.close();
        } catch (IOException ex) {
            Logger.getLogger(NewManagerRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 기존에 있던 사업자등록정보를 읽어 리스트 형식으로 저장.
     *
     * @throws IOException
     */
    protected void outFile() throws IOException {
        // 기존에 있던 사업자등록정보를 읽어 리스트 형식으로 저장
        String line;
        File file = new File("./datafile/manager.txt");
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

        for (String info : readInfo) {
            line = info;
            String[] str = line.split("/");
            managerInfo.add(new EM(str[0], str[1], str[2], str[3], str[4], str[5], str[6]));
        }
    }

}
