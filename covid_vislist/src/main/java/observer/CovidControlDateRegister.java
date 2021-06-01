/*
CovidControlDateRegister.java
- observer 패턴
- Observer.java, SaveDate를 상속받는 클래스
- 방역을 한 날짜와 시간에 관련된 클래스
 */
package observer;

public class CovidControlDateRegister implements Observer, SaveDate {

    private String date; //방역 날짜
    private String time; //방역 시간
    private DateData dateData; //

    /**
     * DateData를 인자로 받아 자신을 옵저버로서 등록.
     * DateData를 인자로 받음.
     * registerObserver를 호출하여 자신을 옵저버로서 등록
     * @param dateData 
     */
    CovidControlDateRegister(DateData dateData) {
        this.dateData = dateData;
        this.dateData.registerObserver(this);
    }

    
    /**
     * date, time를 인자로 받아 display와 save를 호출.
     * @param date
     * @param time 
     */
    @Override
    public void update(String date, String time) {
        this.date = date;
        this.time = time;
        display();
        //save();
    }

    /**
     * date와 time을 성공적으로 받았을 때 메시지 출력.
     * 방역 진행
     */
    @Override
    public void display() {
        System.out.printf("%s %s 방역을 성공적으로 진행하였습니다.%n", date, time);
    }

    /**
     * ?
     */
    @Override
    public void save() {
        //출입자 명부 코드가 들어와야 가능
        //리턴 값으로 넘기지 말지 아직 모르기 때문에
    }

}
