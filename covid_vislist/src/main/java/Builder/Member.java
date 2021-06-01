/*
Member.java
- builder 패턴
- Member의 아이디, 비밀번호, 이름
 */
package builder;

/**
 *
 * @author Owner
 */
public class Member {

    private String id; //아이디
    private String pw; //비밀번호
    private String name; //이름

    /**
     * Member 생성자.
     * @param id
     * @param pw
     * @param name 
     */
    public Member(String id, String pw, String name) {
        super();
        this.id = id;
        this.pw = pw;
        this.name = name;
    }

    /**
     * id, pw, name의 getter, setter.
     * @return 
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * id와 pw, name을 문자열로 만들어 리턴.
     * @return 
     */
    @Override
    public String toString() {
        return id + " " + pw + " " + name + "\n";
    }

}