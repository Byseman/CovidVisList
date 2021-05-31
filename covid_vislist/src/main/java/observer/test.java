/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

/**
 *
 * @author Owner
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DateData dateData = new DateData();
        CurrentDateRegister currentDate = new CurrentDateRegister(dateData);
        CovidControlDateRegister controlDate = new CovidControlDateRegister(dateData);
        int i = 1;
        int cnt = 0;
        while(true) {
            dateData.setCurrentDate();
            dateData.removeObserver(controlDate);
            dateData.setCurrentDate();
            controlDate = new CovidControlDateRegister(dateData);
            cnt++;
            if(cnt==3) break;
        }
    }

}
