/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ScreenTools;

import TheaterTools.TheaterState;
import app_poo.DispenserManager;
import app_poo.Screen;
import app_poo.ScreenMode;
import app_poo.Theater;
import java.awt.List;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Cherno
 */
public class DataSelectionScreen extends Screen{
    
    private Map schedule = new HashMap<Date,TheaterState>();
    private AreaSelectionScreen areaScreen;
    
    //Methods
    private List getDatesFromToday(){
        return null;
    }
    
    private void loadStateFiles(){
        
    }
    
    //Construct
    public DataSelectionScreen(Theater theater, DispenserManager dispenserManager, String title, ScreenMode mode) {
        super(dispenserManager, title, mode);
    }
    
}
