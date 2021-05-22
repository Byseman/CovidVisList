/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

/**
 *
 * @author Owner
 */
public class Manager {
    
    RegisterBehavior strategy;
    
    public void setRegisterBehavior(RegisterBehavior strategy){
        this.strategy = strategy;
    }
    
    public void performRegister(){
        strategy.register();
    }
    
}
