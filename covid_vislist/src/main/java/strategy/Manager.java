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
    
    Strategy strategy;
    
    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }
    
    public void performinput(){
        strategy.input();
    }
}
