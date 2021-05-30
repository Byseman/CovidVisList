
package proxy;

public class Proxy implements List {
    
  private RealSubject reallist;
  private String filename;

  @Override
  public boolean displayList( ) {
      if(reallist == null){
          reallist = new RealSubject(filename);
      }
      reallist.displayList();
      return true;
  }

}
