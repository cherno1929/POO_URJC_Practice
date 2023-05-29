/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ScreenTools;

import TheaterTools.SeatState;
import TheaterTools.TheaterAreaState;
import TheaterTools.TheatherArea;
import app_poo.DispenserHardware;
import app_poo.DispenserManager;
import app_poo.Screen;
import app_poo.ScreenMode;
import app_poo.ScreenResult;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cherno
 */
public class SeatSelectionScreen extends Screen{
    
    private TheaterAreaState areaSt;
    private PaymentScreen paySc;
    private int n_Butacas = 0;
    private String location = "";
    
    public ScreenResult optionButtonPressed(char c){
        return null;
    } 
    
    public ScreenResult seatButton(int row, int col){
        return null;
    } 
    
    public void updateState(){
        
    } 
    
    private int computePrice(){
        TheatherArea areaPrice = new TheatherArea(title);
        return this.n_Butacas * this.areaSt.getPrice();
    }
    
    @Override
    public ScreenResult begin(DispenserHardware dispHrd){
        return ScreenResult.continueScreen;
    }
    
    public int getRows(){
        return this.areaSt.getRows();
    }
    
    public int getCols(){
        return this.areaSt.getCols();
    }
    
    public TheaterAreaState getAreaState() {
        return this.areaSt;
    }
    
    public List<String> getOptions(){
        List<String> options = new ArrayList<String>();
        options.add("Salir");
        options.add("Terminar");
        return options;
    }
    
    public ScreenResult optionButtonPressed(DispenserHardware hardw, char option){
        if (option == 'A') {
            return ScreenResult.exitScreen;
        }else if (option == 'B') {
            if (this.n_Butacas > 0) {
                this.paySc = new PaymentScreen(this.computePrice(),"",dispenserManager, "Pantalla de Pago", mode);
                this.dispenserManager.showScreen(30, this.paySc);
                return ScreenResult.exitScreen;
            } else{
                this.dispenserManager.setTitle("Usted no tiene ticket");
            }
        }else {
            int row = (byte)((option & 0xFF00) >> 8);
            int col = (byte)(option & 0xFF);
            this.dispenserManager.markSear(row, col);
            this.n_Butacas++;
            this.areaSt.fillSeat(row - 1, col - 1);
        }
        return ScreenResult.continueScreen;
    }
    
    //Constr
    
    public SeatSelectionScreen(TheaterAreaState areaSt ,DispenserManager dispenserManager, String title, ScreenMode mode) {
        super(dispenserManager, title, mode);
        this.areaSt = areaSt;
    }
    
    
}
