
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lvsena
 */
public class PhoneRepository {
     public boolean exists(String phone) throws IOException {
        ArrayList<String> allPhone = getAll();
        
        if (allPhone.indexOf(phone) != -1) {
            return true;
        }
        
        return false;
     }
    
     public void savePhoneOnFile(String phone) throws IOException {
        try {
            FileWriter arq = new FileWriter("phone-numbers.txt", true);
            PrintWriter writer = new PrintWriter(arq);
            writer.write(phone + "\n");
            writer.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<String> getAll() throws FileNotFoundException, IOException {
        FileReader arq = new FileReader("phone-numbers.txt");
        BufferedReader reader = new BufferedReader(arq);
        ArrayList<String> phonesList = new ArrayList();
        String line;
        
        do {
           line = reader.readLine();
           phonesList.add(line);
        } while(line != null);
        
        
        return phonesList;
    }    
}
