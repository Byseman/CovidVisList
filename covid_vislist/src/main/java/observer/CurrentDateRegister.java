/*
CurrentDateRegister.java
- observer 패턴
- Observer.java, SaveDate를 상속받는 클래스
- 명부 작성을 한 시간과 날짜를 출력과 변수 저장에 관련된 클래스
 */
package observer;

/**
 *
 * @author Owner
 */
public class CurrentDateRegister implements Observer, SaveDate {

    private String date; // 출입 명부 입력 날짜
    private String time; // 출입 명부 입력 시간
    private DateData dateData; //
    
    
     /**
     * DateData를 인자로 받아 자신을 옵저버로서 등록.
     * DateData를 인자로 받음.
     * registerObserver를 호출하여 자신을 옵저버로서 등록
     * @param dateData 
     */
    public CurrentDateRegister(DateData dateData){
        this.dateData = dateData;
        this.dateData.registerObserver(this);
    }
    
    
    /**
     * date, time를 인자로 받아 display와 save를 호출.
     * @param date
     * @param time 
     */
    public void update(String date, String time) {
        this.date = date;
        this.time = time;
        display();
        //save();
    }

    
    /**
     * date와 time을 성공적으로 받았을 때 메시지 출력.
     * 출입 명부 작성
     */
    @Override
    public void display() {
        System.out.printf("%s %s 성공적으로 등록되었습니다.%n", date, time);
    }

    
    /**
     * 
     */
    @Override
    public void save() {
        //출입자 명부가 들어와야 가능
        //리턴 값으로 넘기지 말지 아직 모르기 때문에
    }

}
