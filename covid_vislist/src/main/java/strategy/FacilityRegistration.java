/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

/**
 *
 * @author Owner1ss
 * 
 */
public class FacilityRegistration {
    public static void main(String[] args){
        Manager input = new Manager();  
        input.setStrategy(new NM("","","","00000000000","","",""));      
    }
}
