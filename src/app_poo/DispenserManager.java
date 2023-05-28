/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app_poo;

import TheaterTools.TheaterAreaState;
import java.util.ArrayList;
import java.util.List;
import sienens.TheaterTicketDispenser;

/**
 *
 * @author Cherno
 */
public class DispenserManager {
    
    private TranslatorManager translator = new TranslatorManager();
    private TheaterTicketDispenser dispenser = new TheaterTicketDispenser();
    private DispenserHardware dispenserHardw;
    
    //Methods
    public void showScreen(int time, Screen screen){
        ScreenResult result = screen.begin(dispenserHardw);
        this.setMode(screen);
        
        while (result == ScreenResult.continueScreen) {
            this.dispenser.setTitle(screen.getTitle());
            this.dispenser.setDescription(screen.getDescription());
            this.dispenser.setImage(screen.getImage());
            
            this.getOptions(screen);
            
            char data = this.dispenser.waitEvent(30);
            if (data == '0'){
                result = screen.end(this.dispenserHardw);
            } else {
                result = screen.optionButtonPressed(this.dispenserHardw, data);
            }
        }
    }
    
    private void setMode(Screen screen){
        if (screen.getMode() == ScreenMode.optionsMode) {
            this.dispenser.setMenuMode();
        } else if (screen.getMode() == ScreenMode.messageMode) {
            this.dispenser.setMessageMode();
        } else if (screen.getMode() == ScreenMode.theaterMode) {
            this.dispenser.setTheaterMode(0, 0);
        }
    }
    
    private void getOptions(Screen screen) {
        int i = 0;
        for (String option : screen.getOptions()){
            this.dispenser.setOption(i, option);
            i++;
        }
    }
    
    private void drawArea(TheaterAreaState thAreaState){
        
    }
    
    public DispenserHardware getHardware(){
        return this.dispenserHardw;
    }
    //Constructor

   
    
    
}
