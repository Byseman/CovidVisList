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
class EM extends StrategyExistingManager{

    private ArrayList<String> readInfo = new ArrayList<>();
    private ArrayList<EM> managerInfo = new ArrayList<>(); 
    
    public EM(String facilityName, String licenseNum, String presidentName, String facilityNum, String businessType, String facilityZone, String facilityAddress) {
        super(facilityName, licenseNum, presidentName, facilityNum, businessType, facilityZone, facilityAddress);
    }
    
    Scanner sc = new Scanner(System.in);
    
    protected void inFName() {

        String input;
        int check = 0;
        
        System.out.print("상호명:");
        input = sc.next();
        
        for (EM info:managerInfo) {
            if (info.presidentName.equals(this.presidentName)) {
                if(info.facilityName.equals(input)){
                    check = 1;
                }
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
    
    protected boolean inLNum() {
        
        String input;
        int check = 0;
        
        System.out.print("사업자 등록번호:");
        input = sc.next();
        
        for (EM info:managerInfo) {
            if (info.licenseNum.equals(input)) {
                check = 1;
            }
        }
        if(check == 0){
            this.licenseNum = input;
            return false;
        }
        else {
            this.licenseNum = input;
            return true;
        }
        
    }
    
    protected boolean inPName(){
        
        String input;
        int check = 0;
        
        System.out.print("대표자명:");
        input = sc.next();
        
        for (EM info:managerInfo) {
            if (info.licenseNum.equals(this.licenseNum)) {
                if (info.presidentName.equals(input)) {
                    check = 1;
                }
            }
        }
        if(check == 0){
            System.out.println("등록되지 않은 시설이거나 사업자등록번호, 대표자명이 일치하지 않습니다.");
            return false;
        }
        else {
            this.presidentName = input;
            return true;
        }
        
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
        input = sc.next();
        
        for (EM info:managerInfo) {
            if (info.presidentName.equals(this.presidentName)) {
                if(info.facilityAddress.equals(input)){
                    check = 1;
                }
            }
        }
        
        if(check == 0){
            this.facilityAddress = input;
        }
        else {
            System.out.println("이미 존재하는 시설입니다.");
            inFAddress();
        }
    }

    protected void inFile(String info){
        
        BufferedWriter bf = null;
        try {
            bf = new BufferedWriter(new FileWriter("C:\\DB\\ManagerInfo.txt", true));
            PrintWriter pw = new PrintWriter(bf, true);
            pw.write(info + "\n");
            pw.flush();
            pw.close();
        } catch (IOException ex) {
            Logger.getLogger(StrategyNewManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bf.close();
            } catch (IOException ex) {
                Logger.getLogger(StrategyNewManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        sc.close(); 
    }
    
    protected void outFile() throws IOException {
        FileReader fileRead = new FileReader(new File("C:\\DB\\ManagerInfo.txt"));
        BufferedReader bfReader = new BufferedReader(fileRead);
        
        String line;
        while ((line = bfReader.readLine()) != null) {
             readInfo.add(line);
        }
        
        for (String info: readInfo) {
            line = info;
            String[] str = line.split("/");
            System.out.println(str[0]);
            managerInfo.add(new EM(str[0], str[1], str[2], str[3], str[4], str[5], str[6]));
        } 
    }

}
