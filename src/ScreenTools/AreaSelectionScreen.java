/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ScreenTools;

import TheaterTools.TheaterAreaState;
import TheaterTools.TheaterState;
import TheaterTools.TheatherArea;
import app_poo.DispenserHardware;
import app_poo.DispenserManager;
import app_poo.Screen;
import app_poo.ScreenMode;
import app_poo.ScreenResult;
import app_poo.Theater;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Cherno
 */
public class AreaSelectionScreen extends Screen{
    
    private String locationImagePlane = "DataFiles\\Zonas\\plane.png";
    private TheaterState selectArea;
    private SeatSelectionScreen seatSelector;
    
    
    //Methods
    private void displayArea(TheaterAreaState area){
        
    }
    
    @Override
    public String getImage(){
        return this.locationImagePlane;
    }
    
    public ScreenResult begin(DispenserHardware disp){
        
        return ScreenResult.continueScreen;
    }
    
    public List<String> getOptions(){
        List<String> options = new ArrayList<String>();
        for (TheaterAreaState area : this.selectArea.getAreas()){
            options.add(area.getName());
        }
        return options;
    }
    
    public ScreenMode getMode(){
        return ScreenMode.optionsMode;
    }
    
    public ScreenResult optionButtonPressed(DispenserHardware dispHard, char option){
        int opt = (int) option;
        opt -= 65;
        this.seatSelector = new SeatSelectionScreen(this.selectArea.getArea(opt),dispenserManager, "Seleccione sitio", ScreenMode.theaterMode);
        this.dispenserManager.showScreen(30, this.seatSelector);
        return ScreenResult.exitScreen;
    }
    
    //Construct
    
    public AreaSelectionScreen(TheaterState areaState, DispenserManager dispenserManager, String title, ScreenMode mode) {
        super(dispenserManager, title, mode);
        this.selectArea = areaState;
        this.options = new ArrayList<String>();
    }
    
}
