package state;

import java.io.File;
import java.nio.file.*;
import java.io.IOException;

class overState implements state {

    @Override
    public void deleteVisitLog() {
        boolean deleteList[];
        int fileIndex;
        String file_path = "C:\\Users\\CHOIM\\Downloads\\test"; // 정의해야함, 방문자 명부가 어느 폴더에 작성되는지 알게 되면 집어넣을 것.
        final File dir = new File(file_path); // 파일 읽을 경로
        final File[] fileList = dir.listFiles(); // 파일 리스트 불러오기
        deleteList = visitLogStatus.getDeleteList();
        try {
            for (fileIndex = 0; fileIndex < fileList.length; fileIndex++) {
                if (deleteList[fileIndex] == true) {
                    fileList[fileIndex].delete();
                }
            }
        }
        catch(Exception e) { // 실패 시 예외 처리
            e.printStackTrace();
        }

    }

}
