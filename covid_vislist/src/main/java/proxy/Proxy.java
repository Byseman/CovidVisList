package proxy;

public class Proxy implements List {

    private RealSubject reallist;
    private String filename;
    
    // initialize 추가
    public Proxy(String filename) {
        this.filename = filename;
    }

    @Override
    public void displayList() {
        if (reallist == null) {
            reallist = new RealSubject(filename);
        }
        reallist.displayList();
    }
}
