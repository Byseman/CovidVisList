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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class signup {

    File file = new File("./datafile/member.txt");
    FileWriter write = null;
    BufferedWriter bf = null;

    Scanner sc = new Scanner(System.in);

    String id;
    String id_check;
    String pw;
    String pw_check;
    String name;
    int infocheck;

    /**
     * 내용 적기. 부가 설명 적기.
     *
     * @throws IOException
     */
    public void sign_up() throws IOException {
        System.out.println("이용약관, 개인정보처리방침을 확인합니다. \n숫자를 입력해주세요(1=동의,0=거절)");
        infocheck = sc.nextInt();

        if (infocheck == 1) {
            System.out.println("이용약관, 개인정보처리방침에 동의하셨습니다.");

            System.out.println("이름을 입력해주세요.");
            name = sc.next();

            id_check ic = new id_check();
            do {
                System.out.println("아이디를 입력해주세요.");
                id_check = sc.next();
            } while (ic.idCheck(id_check)==false);
            id = id_check;

            do {
                System.out.println("비밀번호를 입력해주세요.");
                pw = sc.next();
                System.out.println("비밀번호를 한번 더 입력해주세요.");
                pw_check = sc.next();
            } while (pw == pw_check);

            MemberBuilder memberBuilder = new MemberBuilder();
            Member member = memberBuilder.setID(id).setPW(pw).setName(name).build();

            BufferedWriter bf = null;
            try {
                bf = new BufferedWriter(new FileWriter("./datafile/member.txt", true));
                bf = new BufferedWriter(bf);
                PrintWriter pw = new PrintWriter(bf, true);
                pw.write(member.toString());
                pw.flush();
                pw.close();
            } catch (IOException ex) {
                Logger.getLogger(signup.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    bf.close();
                } catch (IOException ex) {
                    Logger.getLogger(signup.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else {
            System.exit(0);
            System.out.println("이용약관, 개인정보처리방침에 거절하셨습니다\n 회원가입을 종료합니다.");
        }

    }

}
