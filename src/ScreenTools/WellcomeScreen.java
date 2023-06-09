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
import app_poo.Theater;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cherno
 */
public class WellcomeScreen extends Screen{
    
    private Theater theater;
    private DataSelectionScreen dataSelect;
    private IdiomSelectionScreen idiomSelect;
    private Play play = new Play();
    
    //Methods
    public ScreenResult optionButtonPressed(char c){
        return null;
    }
    
    @Override
    public ScreenResult begin(DispenserHardware dispHard) {
        
        return ScreenResult.continueScreen;
    }
    
    public String getTitle(){
        return this.play.getTitle();
    }
    
    public String getDescription(){
        return this.play.getDesctiption();
    }
    
    public String getImage(){
        return this.play.getImage();
    }
    
    public List<String> getOptions(){
        List<String> options = new ArrayList<String>();
        options.add(this.idiomSelect.getTitle());
        options.add(this.dataSelect.getTitle());
        for (int i = 0; i < 4; i++){
            options.add("");
        }
        return options;
    }
    
    
    public ScreenResult end(){
        return ScreenResult.continueScreen;
    }
    
    public ScreenResult optionButtonPressed(DispenserHardware dispHard, char opt){
        ScreenResult result = ScreenResult.continueScreen;
        if (opt == 'A') {
            this.dispenserManager.showScreen(30, this.idiomSelect);
        } else if (opt == 'B') {
            this.tk.title = this.play.getTitle();
            this.dispenserManager.showScreen(30, this.dataSelect);
        }
        return result;
    }
    
    //Construct
    
    public WellcomeScreen(Theater theater , DispenserManager dispenserManager, String title, ScreenMode mode) {
        super(dispenserManager, title, mode);
        this.tk = new Ticket(this.dispenserManager.getTranslator());
        this.theater = theater;
        this.idiomSelect = new IdiomSelectionScreen(dispenserManager, "Selección de idioma", ScreenMode.optionsMode);
        this.dataSelect = new DataSelectionScreen(this.tk,theater, dispenserManager, "Selección de fecha de representación", ScreenMode.optionsMode);
    }
    
}
