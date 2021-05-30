
package proxy;

import java.util.ArrayList;

class RealSubject implements List {
  private ArrayList<List> list;
  private String filename;

  public RealSubject(String filename) {
      this.filename = filename;
  }

  private void LoadList(String filename) {
  }

  public boolean displayList( ) {
      System.out.println("print");
      return true;
  }

}
