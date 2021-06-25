
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lvsena
 */
public class PhoneNumberGeneratorSingleton {

    private static PhoneNumberGeneratorSingleton instance;

    public synchronized static PhoneNumberGeneratorSingleton getInstance() {
        if (instance == null) {
            instance = new PhoneNumberGeneratorSingleton();
        }

        return instance;
    }

    private PhoneNumberGeneratorSingleton() {}

    public synchronized String generatePhoneNumber() throws IOException {
        Random rand = new Random();
        PhoneRepository phoneRepository = new PhoneRepository();
        String phone = "";
        int maxPhoneDigit = 9;
        int maxDigitInterval = 10;
        boolean phoneAlreadyExists = true;
        
        while (phoneAlreadyExists) {
            for (int phoneDigitIndex = 0; phoneDigitIndex < maxPhoneDigit; phoneDigitIndex++) {
                phone += rand.nextInt(maxDigitInterval);
            }
            
            phoneAlreadyExists = phoneRepository.exists(phone);
        }
        
        phoneRepository.savePhoneOnFile(phone);
        
        return phone;
    }
}
