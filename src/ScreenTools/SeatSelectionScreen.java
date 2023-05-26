/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ScreenTools;

import TheaterTools.TheaterAreaState;
import app_poo.DispenserManager;
import app_poo.Screen;
import app_poo.ScreenMode;
import app_poo.ScreenResult;

/**
 *
 * @author Cherno
 */
public class SeatSelectionScreen extends Screen{
    
    private TheaterAreaState selectArea = new TheaterAreaState();
    private PaymentScreen paySc;
    
    public ScreenResult optionButtonPressed(char c){
        return null;
    } 
    
    public ScreenResult seatButton(int row, int col){
        return null;
    } 
    
    public void updateState(){
        
    } 
    
    private void computePrice(){
        
    }
    
    //Constr
    public SeatSelectionScreen(DispenserManager dispenserManager, String title, ScreenMode mode) {
        super(dispenserManager, title, mode);
    }
    
    
    
}
