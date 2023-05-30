/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ScreenTools;

import app_poo.DispenserManager;
import app_poo.Screen;
import app_poo.ScreenMode;
import app_poo.ScreenResult;

/**
 *
 * @author Cherno
 */
public class IdiomSelectionScreen extends Screen{
    
    //Methods
    public ScreenResult optionButtonPressed(char c){
        return null;
    }
    
    public ScreenMode getScreenMode(){
        return null;
    }
    
    
    //Contructor
    public IdiomSelectionScreen(DispenserManager dispenserManager, String title, ScreenMode mode) {
        super(dispenserManager, title, mode);
    }

    
}
