/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app_poo;

import TheaterTools.TheaterAreaState;
import java.util.List;

/**
 *
 * @author Cherno
 */
public class Screen {
    
    //Atributes
    private DispenserManager dispenserManager;
    private String title;
    private String description;
    private String image;
    private List<String> options;
    public ScreenMode mode;
    
    //Methods
    public ScreenResult optionButtonPressed(DispenserHardware d, char c){
        return null;
    }
    
    public ScreenResult seatButtonPressed(DispenserHardware d){
        return null;
    }
    
    public ScreenResult creditCardDetected(DispenserHardware d){
        return null;
    }
    
    public TheaterAreaState getAreaState(){
        return null;
    }
    
    public ScreenResult begin(DispenserHardware d){
        return null;
    }
    
    public ScreenResult end(DispenserHardware d){
        return null;
    }
    
    //Get_Set

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public List<String> getOptions() {
        return options;
    }

    public ScreenMode getMode() {
        return mode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
    
    //Constrct

    public Screen(DispenserManager dispenserManager, String title, ScreenMode mode) {
        this.dispenserManager = dispenserManager;
        this.title = title;
        this.mode = mode;
    }
    
    
}
