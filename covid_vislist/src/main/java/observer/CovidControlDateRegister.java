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
public class CovidControlDateRegister implements Observer, SaveDate {

    private String date;
    private String time;
    private DateData dateData;

    CovidControlDateRegister(DateData dateData) {
        this.dateData = dateData;
        this.dateData.registerObserver(this);
    }

    @Override
    public void update(String date, String time) {
        this.date = date;
        this.time = time;
        display();
        //save();
    }

    @Override
    public void display() {
        System.out.printf("%s %s 방역을 성공적으로 진행하였습니다.%n", date, time);
    }

    @Override
    public void save() {
        //출입자 명부 코드가 들어와야 가능
        //리턴 값으로 넘기지 말지 아직 모르기 때문에
    }

}
