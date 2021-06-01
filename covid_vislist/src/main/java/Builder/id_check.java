/*
id_check.java
- builder 패턴
- 아이디 중복 체크
 */
package builder;

/**
 *
 * @author Owner
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class id_check {

    private ArrayList<String> readInfo = new ArrayList<>();

    public boolean idCheck(String id) {
        String line;
        int check  = 0;
        try {

            try (BufferedReader bos = new BufferedReader(new FileReader("./datafile/member.txt"))) {
                String[] array = new String[3];
                while ((line = bos.readLine()) != null) {
                    readInfo.add(line);
                }
            }
        } catch (IOException E10) {
            E10.printStackTrace();
        }

        for (String info : readInfo) {
            line = info;
            String[] str = line.split(" ");
            if (id.equals(str[0])) {
                System.out.println("존재하는 아이디입니다.");
                check=1;
                break;
            } else {
                check = 0;
            }
        }
        if (check == 0) return true;
        else return false;
    }
}
