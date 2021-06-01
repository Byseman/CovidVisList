
package state;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.NoSuchFileException;


class lessState implements state {
  public void deleteVisitLog() {
      System.out.println("지울 파일이 없습니다!");
  }

}
