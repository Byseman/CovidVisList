/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder;

/**
 *
 * @author Owner
 */
public class InfoBuilder {

    private String name;
    private String ID;
    private String PW;
    private String PW_check;
    private int infocheck;

    public InfoBuilder(String name, String ID, String PW, String PW_check, int infocheck) {
        this.name = name;
        this.ID = ID;
        this.PW = PW;
        this.PW_check = PW_check;
        this.infocheck = infocheck;
    }

    public InfoBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public InfoBuilder setID(String ID) {
        this.ID = ID;
        return this;
    }

    public InfoBuilder setPW(String PW) {
        this.PW = PW;
        return this;
    }

    public InfoBuilder setPW_check(String PW_check) {
        this.PW_check = PW_check;
        return this;
    }

    public InfoBuilder setInfocheck(int infocheck) {
        this.infocheck = infocheck;
        return this;
    }
}
