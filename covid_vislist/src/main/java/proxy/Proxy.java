/*
prxy.java
- Proxy 패턴의 Proxy 역할
 */
package proxy;

public class Proxy implements List {

    private RealSubject reallist;
    private String filename;
    
    /**
     * 파일의 이름을 받아 변수 값 지정
     * @param filename 
     */
    public Proxy(String filename) {
        this.filename = filename;
    }

    /**
     * 출입 명부를 RealSubject에서 출력.
     * RealSubject의 reallist 값이 없을 경우 RealSubject에 파일 이름을 넘김.
     * 
     */
    @Override
    public void displayList() {
        if (reallist == null) {
            reallist = new RealSubject(filename);
        }
        reallist.displayList();
    }
}
