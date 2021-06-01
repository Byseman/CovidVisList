/*
DateData.java
- observer 패턴의 요소인 ConCreteSubject 객체에 해당
*/
package observer;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class DateData extends Subject {

    private String date; //날짜
    private String time; //시간

    /**
     * 옵저버의 정보를 가지는 List.
     */
    public DateData() {
        observers = new LinkedList<>();
    }

    /**
     * 옵저버를 구독자로 등록하는 registerObserver.
     * @param o 
     */
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    /**
     * 옵저버의 구독을 해지하는 removeObserver.
     * @param o 
     */
    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    /**
     * 옵저버에 정보를 전달하는 notifyObservers.
     */
    @Override
    public void notifyObservers() {
        observers.forEach((observer) -> {
            observer.update(date, time);
        });
    }
    
    public void checkDate() {
        notifyObservers();
    }

    /**
     * 사용자가 출입 명부(방역 시) 작성 시 현재 시간과 날짜 저장.
     * 날짜와 시간을 저장
     */
    public void setCurrentDate() {
        GregorianCalendar today = new GregorianCalendar();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-M-d a");
        SimpleDateFormat st = new SimpleDateFormat("hh:mm:ss");

        date = sd.format(today.getTime());
        time = st.format(today.getTime());
        checkDate();
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

}
