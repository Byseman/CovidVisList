/*
strategy 적용 예시
 */
package strategy;

public class FacilityRegistration {

    public static void main(String[] args){
        Manager input = new Manager();
        
        // 신규 사업자 정보 등록
        input.setRegisterBehavior(new NM("상호명","사업자 등록번호","대표자명","01012341234","업종","관할지역","사업장 주소"));   
        input.performRegister();
        
        // 기존 사업자 정보 등록
        input.setRegisterBehavior(new EM("상호명","사업자 등록번호","대표자명","01012341234","업종","관할지역","사업장 주소"));   
        input.performRegister();
    }
}
