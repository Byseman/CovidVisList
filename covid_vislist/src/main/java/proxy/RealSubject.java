
package proxy;

import java.util.ArrayList;

class RealSubject implements List {
  private ArrayList<List> list;
  private String filename;

  public RealSubject(String filename) {
  }

  private void LoadList(String filename) {
  }

  public boolean displayList( ) {
      return true;
  }

}
