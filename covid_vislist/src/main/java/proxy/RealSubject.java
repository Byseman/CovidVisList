/**
 * 
 */
package proxy;

import java.util.ArrayList;

class RealSubject implements List {

    private ArrayList<String> list = new ArrayList<>();
    private String filename;

    public RealSubject(String filename) {
        this.filename = filename;
    }

    /**
     * 파일 로딩.(정확한 건 이후 작성).
     * 부가적 설명
     * @param filename 
     */
    private void LoadList(String filename) {
        System.out.println("파일 로딩 중");
        // list에 코드 넣기 (리스트 한 줄 형식으로 저장 원합니다~!~)
    }

    /**
     * 출입명부 화면에 출력(정확한 건 이후 작성).
     * 부가적 설명
     */
    @Override
    public void displayList() {
        if (list.get(0) == null) {
            System.out.println("출입명부가 존재하지 않습니다.");
        } else {
            for (String list : list) {
                System.out.println(list);
            }
        }
    }
}
