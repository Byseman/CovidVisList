/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Owner
 */
abstract class StrategyExistingManager implements Strategy {
    
    protected String facilityName;
    protected String licenseNum;
    protected String presidentName;
    protected String facilityNum;
    protected String businessType;
    protected String facilityZone;
    protected String facilityAddress;

    public StrategyExistingManager(String facilityName, String licenseNum, String presidentName, String facilityNum, String businessType, String facilityZone, String facilityAddress) {
        this.facilityName = facilityName;
        this.licenseNum = licenseNum;
        this.presidentName = presidentName;
        this.facilityNum = facilityNum;
        this.businessType = businessType;
        this.facilityZone = facilityZone;
        this.facilityAddress = facilityAddress;
    }
    
    @Override
    public void input() {
        
        try {
            outFile();
        } catch (IOException ex) {
            Logger.getLogger(StrategyNewManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean check[] = new boolean[3];
        
        do{
            check[0] = inLNum();
            check[1] = inPName();
        }while (check[0] == false || check[1] == false);
        
        inFName();
        
        do{
            check[2] = inFNum();
        }while (check[2] == false);
        
        inBType();
        inFZone();
        inFAddress();
        
        String info; 
        info = facilityName + '|' + licenseNum + '|' + presidentName + '|' 
                + facilityNum + '|' + businessType + '|' + facilityZone + '|' + facilityAddress;
        System.out.print(info);
        fileInput(info);
        
    }
    
    @Override
    public void fileInput(String info) {  
        inFile(info);
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
