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
public class CurrentDateRegister implements Observer, SaveDate {

    private String date;
    private String time;
    private DateData dateData;
    
    public CurrentDateRegister(DateData dateData){
        this.dateData = dateData;
        this.dateData.registerObserver(this);
    }
    
    public void update(String date, String time) {
        this.date = date;
        this.time = time;
        display();
        //save();
    }

    @Override
    public void display() {
        System.out.printf("%s %s 성공적으로 등록되었습니다.%n", date, time);
    }

    @Override
    public void save() {
        //출입자 명부가 들어와야 가능
        //리턴 값으로 넘기지 말지 아직 모르기 때문에
    }

}
