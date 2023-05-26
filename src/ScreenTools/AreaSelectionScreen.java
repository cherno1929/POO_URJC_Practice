/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ScreenTools;

import TheaterTools.TheaterAreaState;
import app_poo.DispenserManager;
import app_poo.Screen;
import app_poo.ScreenMode;

/**
 *
 * @author Cherno
 */
public class AreaSelectionScreen extends Screen{
    
    private TheaterAreaState selectArea;
    private SeatSelectionScreen seatSelector;

    public AreaSelectionScreen(DispenserManager dispenserManager, String title, ScreenMode mode) {
        super(dispenserManager, title, mode);
    }
    
    //Methods
    private void displayArea(TheaterAreaState area){
        
    }
    
    
}
