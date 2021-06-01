/*
builder.java
- builder 패턴
- builder 역할.
 */
package builder;

/**
 *
 * @author Owner
 */
public class MemberBuilder {

    private String id; //사용자 아이디
    private String pw; //사용자 비밀번호
    private String name; //사용자 이름
    private Member member;

    /**
     * member의 초깃값.
     */
    private MemberBuilder() {
        member = new Member("default", "default", "default");
    }

    /**
     * 아이디를 받음.
     * @param id
     * @return 
     */
    public static MemberBuilder setId(String id) {
        MemberBuilder builder = new MemberBuilder();
        builder.member.setId(id);
        return builder;
    }

    /**
     * 비밀번호를 받음.
     * @param pw
     * @return 
     */
    public MemberBuilder setPw(String pw) {
        member.setPw(pw);
        return this;
    }

    /**
     * 이름을 받음.
     * @param name
     * @return 
     */
    public MemberBuilder setName(String name) {
        member.setName(name);
        return this;
    }

    
    /**
     * build.
     * member 값을 리턴함
     * @return 
     */
    public Member build() {
        return this.member;
    }
}