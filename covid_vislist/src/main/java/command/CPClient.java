/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

/**
 *
 * @author Jiwon
 */
public class CPClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 파일입출력 기능의 정상작동 확인을 위한 테스트 코드
        Signin signin = new Signin();
        ActionListenerCommand signinCommand = new ActionSignin(signin);
        MenuOptions menuoptions = new MenuOptions();
        
        menuoptions.setCommand(signinCommand);
        menuoptions.select();
    }
    
}
