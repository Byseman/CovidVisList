/*
Manager.java
- Strategy 패턴
- Client
*/
package strategy;

public class Manager {
    
    RegisterBehavior strategy; // 행동 인터페이스(RegisterBehavior) 형식의 레퍼런스 변수 선언
    
    public void setRegisterBehavior(RegisterBehavior strategy){
        // 행동을 바꾸기 위한 메소드
        this.strategy = strategy; 
    }
    
    public void performRegister(){ 
       // 행동 클래스에 위임
        strategy.register();
    }
    
}
