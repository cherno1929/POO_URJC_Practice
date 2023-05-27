/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app_poo;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Cherno
 */
public class TranslatorManager {
    
    private Map<String,Translator> translatorMap = new HashMap<>();
    private String activeIdiom = "Castellano";
    private String locationIdioms = "DataFiles//Idioms";
    
    public String translate(String msg){
        return null;
    }

    //Construct

    public TranslatorManager() {
        File idiomFiles = new File(this.locationIdioms);
        for(File idiomFil : idiomFiles.listFiles()){
            Translator idiom = new Translator(idiomFil.getPath());
            this.translatorMap.put(idiomFil.getName(), idiom);
        }
        
    }
    
}
