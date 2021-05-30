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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author window
 */
public class pw_check {
        try {
            Scanner sc = new Scanner(System.in);
            String PW_Check;
            System.out.println("비밀번호를 한번 더 입력해주세요.");
            PW_Check=sc.next();
            
            String[] array;
            BufferedReader bos = new BufferedReader(new FileReader("Signup.txt"));
            while ((PW_Check = bos.readLine()) != null) {
                array = PW_Check.split(" ");
                if (PW_Check.equals(array[1])) {
                    System.out.println("비번이 일치합니다.");
                }
                 else {
                    System.out.println("비번이 일치하지 않습니다.");
                    break;
                }
            }
            bos.close();
        } catch (IOException E10) {
            E10.printStackTrace();
        }
}
