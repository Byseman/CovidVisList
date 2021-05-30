
package proxy;

public class Proxy implements List {
    
  private List list = new RealSubject("");
  private String filename;

  public boolean displayList( ) {
      return true;
  }

}
