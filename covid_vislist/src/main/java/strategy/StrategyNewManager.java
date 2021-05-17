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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Owner
 */
abstract class StrategyNewManager implements Strategy {

    protected String facilityName;
    protected String licenseNum;
    protected String presidentName;
    protected String facilityNum;
    protected String businessType;
    protected String facilityZone;
    protected String facilityAddress;

    public StrategyNewManager(String facilityName, String licenseNum, String presidentName, String facilityNum, String businessType, String facilityZone, String facilityAddress) {
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
         System.out.println("1");
        try {
            boolean check = false;
            
            try {
                outFile();
            } catch (IOException ex) {
                Logger.getLogger(StrategyNewManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            inFName();
            inLNum();
            inPName();
            
            do{
                check = inFNum();
            }while (check == false);
            
            inBType();
            inFZone();
            inFAddress();
            
            String info;
            info = facilityName + '/' + licenseNum + '/' + presidentName + '/'
                    + facilityNum + '/' + businessType + '/' + facilityZone + '/' + facilityAddress;
            inFile(info);
        } catch (IOException ex) {
            Logger.getLogger(StrategyNewManager.class.getName()).log(Level.SEVERE, null, ex);
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