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

    public String getActiveIdiom() {
        return activeIdiom;
    }

    public void setActiveIdiom(String activeIdiom) {
        this.activeIdiom = activeIdiom;
    }

    public Map<String, Translator> getTranslatorMap() {
        return translatorMap;
    }

    public void setTranslatorMap(Map<String, Translator> translatorMap) {
        this.translatorMap = translatorMap;
    }
    
    
    
    public String translate(String msg){
        if (msg == null){
            return "";
        }else if (msg.contains("-")){
             return msg;
        }else{
            return this.translatorMap.get(this.activeIdiom).translate(msg);
        }
    }

    //Construct

    public TranslatorManager() {
        File idiomFiles = new File(this.locationIdioms);
        for(File idiomFil : idiomFiles.listFiles()){
            Translator idiom = new Translator(idiomFil.getPath());
            String nameIdiom = idiomFil.getName();
            nameIdiom = nameIdiom.substring(0,nameIdiom.length()-4);
            this.translatorMap.put(nameIdiom, idiom);
        }
        
    }
    
}
