/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ScreenTools;

import app_poo.DispenserManager;
import app_poo.Screen;
import app_poo.ScreenMode;
import app_poo.ScreenResult;
import app_poo.Theater;

/**
 *
 * @author Cherno
 */
public class WellcomeScreen extends Screen{
    
    private Theater theater;
    private DataSelectionScreen dataSelect;
    private IdiomSelectionScreen idiomSelect;
    private Play play;
    
    //Methods
    public ScreenResult optionButtonPressed(char c){
        return null;
    }
    
    //Construct
    
    public WellcomeScreen(Theater theater , DispenserManager dispenserManager, String title, ScreenMode mode) {
        super(dispenserManager, title, mode);
        this.theater = theater;
    }
    
}
