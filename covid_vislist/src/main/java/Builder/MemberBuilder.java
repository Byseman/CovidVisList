/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

/**
 *
 * @author Owner
 */
public class MemberBuilder {

    private String id;
    private String pw;
    private String name;
    private Member member;

    private MemberBuilder() {
        member = new Member("default", "default", "default");
    }

    public static MemberBuilder setId(String id) {
        MemberBuilder builder = new MemberBuilder();
        builder.member.setId(id);
        return builder;
    }

    public MemberBuilder setPw(String pw) {
        member.setPw(pw);
        return this;
    }

    public MemberBuilder setName(String name) {
        member.setName(name);
        return this;
    }

    public Member build() {
        return this.member;
    }
}