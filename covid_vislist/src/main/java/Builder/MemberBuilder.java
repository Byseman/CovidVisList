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

    public MemberBuilder setPW(String pw) {
        this.pw = pw;
        return this;
    }

    public MemberBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public MemberBuilder setID(String id) {
        this.id = id;
        return this;
    }

    public Member build() {
        Member member = new Member(id, pw, name);

        return member;
    }
}
