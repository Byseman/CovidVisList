/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 *
 * @author Owner
 */
public class DateData extends Subject {

    private String date;
    private String time;

    public DateData() {
        observers = new LinkedList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        observers.forEach((observer) -> {
            observer.update(date, time);
        });
    }

    public void checkDate() {
        notifyObservers();
    }

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
