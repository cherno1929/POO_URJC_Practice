/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app_poo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cherno
 */
public class Translator {
    
    private Map<String,String> messages = new HashMap<String,String>();
    
    //Methods
    public String translate(String mesg){
        return this.messages.get(mesg);
    }
    
    private void read(String fileName){
        try {
            BufferedReader readerIdiom = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = readerIdiom.readLine()) != null) {
                String[] arr = line.split(":");
                this.messages.put(arr[0], arr[1]);
            }
        } catch (IOException ex) {
            Logger.getLogger(Translator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Construct

    public Translator(String transalatorFile) {
        read(transalatorFile);
    }
    
}
