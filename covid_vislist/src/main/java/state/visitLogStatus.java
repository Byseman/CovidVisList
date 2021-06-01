package state;

import java.time.LocalDate;
import java.io.File;
import java.time.format.DateTimeFormatter;
import java.text.*;

final class visitLogStatus {

    private String logFilePath = "C:\Users\CHOIM\Downloads\test"; // 정의해야함, 방문자 명부가 어느 폴더에 작성되는지 알게 되면 집어넣을 것.
    state currentState = null;
    private File logFileDirectory = new File(logFilePath); // 파일 읽을 경로
    private File[] fileList = logFileDirectory.listFiles(); // 파일 리스트 불러오기
    private String[] compareDay; // 비교를 위해 파일 이름들 저장할 스트링 배열 (LocalDate로 변환하기 전 형태)
    private LocalDate nowDate = LocalDate.now();
    private LocalDate referenceDate = nowDate.minusDays(28);
    private LocalDate[] compareDate;
    private boolean existOldData = false;
    private static boolean isThisDeletableFile[]; // 파일 리스트 배열에 맞춰 지울 파일 여부를 저장할 배열

    public void run() {
        checkDate();
        readFileName();
        compareDate();
        command();
    }

    public void checkDate() {
        // 현재 날짜로부터 28일 전을 LocalDate 형태로 저장된 것
        String strToday = nowDate.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
        // 삭제 기준일 (실행 시점의 28일 전 날짜에 해당)

        System.out.println("오늘은 " + strToday + " 입니다");
    }

    public void readFileName() { // 정규표현식 이용해서 파일 이름 걸러낸 뒤에 넘겨줄 것
        int checkIndex;
        String[] compareDay = new String[fileList.length];
        String referenceDay = referenceDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(referenceDay + " 이전 날짜의 파일을 찾고 있습니다.");
        try {
            if (0 < fileList.length) {
                for (checkIndex = 0; checkIndex < fileList.length; checkIndex++) {
                    if (fileList[checkIndex].isFile()) { // 해당 인덱스의 파일 객체가 파일인지 디렉토리인지 구분하는 절차
                        compareDay[checkIndex] = fileList[checkIndex].getName();
                        if ((compareDay[checkIndex].indexOf(".txt") != -1)) {
                            System.out.println("불러온 파일 이름: " + fileList[checkIndex].getName());
                            // parse 뒤에 넣을 스트링 .txt 제거해서 주기
                            compareDay[checkIndex].substring(compareDay[checkIndex].length() - 5, compareDay[checkIndex].length());
                            compareDate[checkIndex] = LocalDate.parse(compareDay[checkIndex]);
                        } else {
                            System.out.println(fileList[checkIndex].getName() + "파일은 명부 파일이 아니므로 제외되었습니다.");
                            isThisDeletableFile[checkIndex] = false;
                        }
                    } else {// 파일이 아닌 디렉토리가 들어온 경우
                        System.out.println("파일이 아닌 폴더가 발견되었습니다.");
                    }
                }
            }
            else
                System.out.println("로그파일이 존재하지 않습니다.");
        } catch (Exception e) {
         //   e.printStackTrace();
            System.out.println("파일을 불러오는데 실패했습니다.");
            throw e;
        }
    }

    public boolean validationDate(String checkDate) {

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            dateFormat.setLenient(false);
            dateFormat.parse(checkDate);
            return true;

        } catch (ParseException e) {
            return false;
        }

    }

    public void compareDate() { // 빈 배열 생기면 건너뛰는 거 추가할 것, 삭제할 파일이 들은 배열의 특정 위치랑 동일한 위치에 true를 가진 boolean 저장하기
        for (int compareIndex = 0; compareIndex < fileList.length; compareIndex++) {
            if (compareDate[compareIndex].isBefore(referenceDate) == true) { // compareDate와 가장 오래된 날 비교 (처음은 오늘)
                existOldData = true;
                isThisDeletableFile[compareIndex] = true;
            }
        }

    }

    private void command() {
        setState(decideState(existOldData));
    }

    public state decideState(boolean existOldData) {
        if (existOldData == true) {
            return new overState();
        } else {
            return new lessState();
        }
    }

    public void setState(state changedState) {
        currentState = changedState;
    }

    public static boolean[] getDeleteList() {
        return isThisDeletableFile;
    }
}
