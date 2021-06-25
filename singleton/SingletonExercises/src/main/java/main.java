
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lvsena
 */
public class main {
    public static void main(String[] args) throws IOException {
        PhoneNumberGeneratorSingleton phoneGenerator = PhoneNumberGeneratorSingleton.getInstance();
        
        System.out.println(phoneGenerator.generatePhoneNumber());
        System.out.println(phoneGenerator.generatePhoneNumber());
    }
}
