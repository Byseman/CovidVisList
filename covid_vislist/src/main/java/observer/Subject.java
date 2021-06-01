/*
Subject.java
- Subject 인터페이스
*/
package observer;

import java.util.List;

/**
 *
 * @author Owner
 */
public abstract class Subject {

    protected List<Observer> observers; // 옵저버의 정보를 가지는 List
    
    public abstract void registerObserver(Observer o); // 옵저버를 구독자로 등록
    public abstract void removeObserver(Observer o); // 옵저버의 구독을 해지
    public abstract void notifyObservers(); // 옵저버에 정보를 전달
    
}
