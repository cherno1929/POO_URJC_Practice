/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ScreenTools;

import app_poo.DispenserHardware;
import app_poo.DispenserManager;
import app_poo.Screen;
import app_poo.ScreenMode;
import app_poo.ScreenResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Cherno
 */
public class IdiomSelectionScreen extends Screen{
    
    //Methods
    
    public ScreenResult begin(DispenserHardware di){
        return ScreenResult.continueScreen;
    }
    
    public ScreenResult end(DispenserHardware di){
        return ScreenResult.continueScreen;
    }
    
    public List<String> getOptions(){
        return this.options;
    }
    
    public ScreenResult optionButtonPressed(DispenserHardware dispH, char option){
        int opt = ((int) option) - 65;
        this.dispenserManager.getTranslator().setActiveIdiom(this.options.get(opt));
        return ScreenResult.exitScreen;
    }
    
    public ScreenResult optionButtonPressed(char c){
        int opt = ((int) c) - 65;
        this.dispenserManager.asignIdiom(this.getOptions().get(opt));
        return ScreenResult.continueScreen;
    }

    //Contructor
    public IdiomSelectionScreen(DispenserManager dispenserManager, String title, ScreenMode mode) {
        super(dispenserManager, title, mode);
        this.options = new ArrayList<String>(this.dispenserManager.getTranslator().getTranslatorMap().keySet());
        Collections.sort(options);
    }

    
}
