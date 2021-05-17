/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author Owner
 */
class NM extends StrategyNewManager{
    
    private ArrayList<String> readInfo = new ArrayList<>();
    private ArrayList<NM> managerInfo = new ArrayList<>(); 
    
    public NM(String facilityName, String licenseNum, String presidentName, String facilityNum, String businessType, String facilityZone, String facilityAddress) {
        super(facilityName, licenseNum, presidentName, facilityNum, businessType, facilityZone, facilityAddress);
    }
    
    Scanner sc = new Scanner(System.in);
    
    protected void inFName() {
        
        String input;
        int check = 0;
        
        System.out.print("상호명:");
        input = sc.next();
        
        for (NM info:managerInfo) {
            if (info.facilityName.equals(input)) {
                check = 1;
            }
        }
        if(check == 0){
            this.facilityName = input;
        }
        else {
            System.out.println("이미 존재하는 시설입니다.");
            inFName();
        }
    }
    
    protected void inLNum() {
        String input;
        int check = 0;
        
        System.out.print("사업자 등록번호:");
        input = sc.next();
        
        for (NM info:managerInfo) {
            if (info.licenseNum.equals(input)) {
                check = 1;
            }
        }
        if(check == 0){
            this.licenseNum = input;
        }
        else {
            System.out.println("이미 존재하는 사업자 등록번호입니다.");
            inFName();
        }
    }
    protected void inPName(){
        
        System.out.print("대표자명:");
        this.presidentName = sc.next();
        
    }
    protected boolean inFNum(){
        
        String num;
        System.out.print("사업장 전화번호:");
        num = sc.next();
        String numPattern = "^\\d{11}$";
        if(Pattern.matches(numPattern, num)) {
            this.facilityNum = num;           
            return true;
        } else {            
            System.out.println("올바른 휴대전화 형식이 아닙니다. ");
            return false;
        }
    }
    protected void inBType(){
        
        System.out.print("업종:");
        this.businessType = sc.next();

    }
    protected void inFZone(){
        
        System.out.print("관할지역:");
        this.facilityZone = sc.next();
    }
    
    protected void inFAddress(){
        String input;
        int check = 0;
        
        System.out.print("사업장 주소:");
        this.facilityAddress = sc.next();        
//        input = sc.next();
//        
//        for (NM info:managerInfo) {
//            if (info.facilityAddress.equals(input)) {
//                check = 1;
//            }
//        }
//        if(check == 0){
//            this.facilityAddress = input;
//            System.out.println("okay");
//        }
//        else {
//            System.out.println("이미 존재하는 사업자 등록번호입니다.");
//            inFAddress();
//        }
    }
    
    protected void inFile(String info) throws IOException{
        
        BufferedWriter log = new BufferedWriter(new FileWriter("./datafile/manager.txt", true));
        PrintWriter pw = new PrintWriter(log, true);
        pw.write(info + "\n");
        pw.flush();
        pw.close();
    } 
    
    protected void outFile() throws IOException {
        
        FileReader fileRead = new FileReader(new File("./datafile/manager.txt"));
        BufferedReader bfReader = new BufferedReader(fileRead);
        
        String line;
        while ((line = bfReader.readLine()) != null) {
             readInfo.add(line);
        }
        
        for (String info: readInfo) {
            line = info;
            String[] str = line.split("/");
            managerInfo.add(new NM(str[0], str[1], str[2], str[3], str[4], str[5], str[6]));
        }
    }
}

