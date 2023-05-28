/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ScreenTools;

import TheaterTools.TheaterAreaState;
import TheaterTools.TheatherArea;
import app_poo.DispenserManager;
import app_poo.Screen;
import app_poo.ScreenMode;
import java.util.List;

/**
 *
 * @author Cherno
 */
public class AreaSelectionScreen extends Screen{
    
    
    private TheaterAreaState selectArea;
    private SeatSelectionScreen seatSelector;
    
    //Methods
    private void displayArea(TheaterAreaState area){
        
    }
    
    
    //Construct
    public AreaSelectionScreen(List<TheatherArea> thArea, DispenserManager dispenserManager, String title, ScreenMode mode) {
        super(dispenserManager, title, mode);
        
        this.seatSelector = new SeatSelectionScreen(dispenserManager, title, ScreenMode.theaterMode);
    }
    
}
