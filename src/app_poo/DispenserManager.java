/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app_poo;

import ScreenTools.SeatSelectionScreen;
import TheaterTools.SeatState;
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
        
        while (result == ScreenResult.continueScreen) {
            this.setMode(screen);
            this.dispenser.setTitle(this.translator.translate(screen.getTitle()));
            this.dispenser.setDescription(this.translator.translate(screen.getDescription()));
            this.dispenser.setImage(screen.getImage());
            
            this.getOptions(screen);
            
            char data = this.dispenser.waitEvent(30);
            result = screen.optionButtonPressed(this.dispenserHardw, data);
        }
    }
    
    public void explelCard(){
        this.dispenser.expelCreditCard(20);
    }
    
    public void printScreen(String data){
        List<String> info = new ArrayList<String>();
        info.add(data);
        this.dispenser.print(info);
    }
    
    public long retainCard(){
        this.dispenser.retainCreditCard(false);
        return this.dispenser.getCardNumber();
    }
    
    public void setTitle(String title){
        this.dispenser.setTitle(this.translator.translate(title));
    }
    
    private void setMode(Screen screen){
        if (screen.getMode() == ScreenMode.optionsMode) {
            this.dispenser.setMenuMode();
        } else if (screen.getMode() == ScreenMode.messageMode) {
            this.dispenser.setMessageMode();
        } else if (screen.getMode() == ScreenMode.theaterMode) {
            this.dispenser.setTheaterMode(screen.getRows(), screen.getCols());
            this.drawArea(screen.getAreaState());
        }
    }
    
    private void getOptions(Screen screen) {

        int i = 0;
        for (String option : screen.getOptions()){
            
            String[] optArr = option.split("💀");
            if (optArr.length > 1){
                this.dispenser.setOption(i, this.translator.translate(optArr[0]) + " (" + optArr[1] + "€)");
            }else {
                this.dispenser.setOption(i, this.translator.translate(option));
            }

             i++;
        }
        
    }
    
    public void markSear(int row, int col){
        this.dispenser.markSeat(row, col, 1);
    }
    
    public void disMarkSear(int row, int col){
        this.dispenser.markSeat(row, col, 2);
    }
    
    private void drawArea(TheaterAreaState thAreaState){
        int j;
        for (int i = 0; i < thAreaState.getRows(); i++) {
            j = 0;
            while (j < thAreaState.getCols()) {
                if (thAreaState.getSeatsState(i, j) == null) {
                    this.dispenser.markSeat(i + 1, j + 1, 0);
                } else if (thAreaState.getSeatsState(i, j) == SeatState.occupied) {
                    this.dispenser.markSeat(i + 1, j + 1, 1);
                }
                j++;
            }
        }
    }

    public TranslatorManager getTranslator() {
        return translator;
    }

    public void setTranslator(TranslatorManager translator) {
        this.translator = translator;
    }
    
    
    
    public DispenserHardware getHardware(){
        return this.dispenserHardw;
    }
    
    public void asignIdiom(String opt) {
        this.translator.setActiveIdiom(opt);
    }
    
    //Constructor

    

   
    
    
}
