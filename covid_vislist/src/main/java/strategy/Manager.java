/*
Manager.java
- Strategy 패턴
- Client
*/
package strategy;

public class Manager {
    
    RegisterBehavior strategy; // 행동 인터페이스(RegisterBehavior) 형식의 레퍼런스 변수 선언
    
    /**
     * 행동을 바꾸기 위한 메소드.
     * 기존 사업자등록정보를 입력받을지 신규 사업자등록정보를 입력받을지
     * 런 타임 시에 조금 더 쉽게 바꿀 수 있음.
     * @param strategy 
     */
    public void setRegisterBehavior(RegisterBehavior strategy){
        // 행동을 바꾸기 위한 메소드
        this.strategy = strategy; 
    }
    
    /**
     * 행동 클래스에 위임.
     * 행동 클래스
     * ExistingManagerRegister(기존 사업자등록정보)
     * NewManagerRegister(신규 사업자등록정보)
     */
    public void performRegister(){ 
       // 행동 클래스에 위임
        strategy.register();
    }
    
}
