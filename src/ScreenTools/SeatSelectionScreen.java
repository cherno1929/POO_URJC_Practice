/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ScreenTools;

import TheaterTools.TheaterAreaState;
import app_poo.DispenserHardware;
import app_poo.DispenserManager;
import app_poo.Screen;
import app_poo.ScreenMode;
import app_poo.ScreenResult;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        this.areaSt.searchPrice();
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
        if (option == 'A' || option == '0') {
            return ScreenResult.exitScreen;
        }else if (option == 'B') {
            if (this.n_Butacas > 0) {
                
                this.paySc = new PaymentScreen(this,this.tk,this.computePrice(),"",dispenserManager, "Inserte tarjeta", ScreenMode.messageMode);
                this.dispenserManager.showScreen(30, this.paySc);
                return ScreenResult.exitScreen;
            } else{
                this.dispenserManager.setTitle("Usted no tiene ticket");
            }
        }else {
            int row = (byte)((option & 0xFF00) >> 8);
            int col = (byte)(option & 0xFF);
            this.tk.rows.add(row);
            this.tk.cols.add(col);
            this.dispenserManager.markSear(row, col);
            this.n_Butacas++;
            this.areaSt.fillSeat(row - 1, col - 1);
        }
        return ScreenResult.continueScreen;
    }
    
    public void modifyZone(Ticket tkr) {
        File fileToUpdate = new File(tkr.locationZone);
        try {
            BufferedWriter writerTk = new BufferedWriter(new FileWriter(fileToUpdate));
            String newTxt = DataSelectionScreen.transformSeat_To_String(tkr.actualZoneState);
            writerTk.write(newTxt);
            writerTk.close();
        } catch (IOException ex) {
            Logger.getLogger(SeatSelectionScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Constr
    
    public SeatSelectionScreen(Ticket tk,TheaterAreaState areaSt ,DispenserManager dispenserManager, String title, ScreenMode mode) {
        super(dispenserManager, title, mode);
        this.areaSt = areaSt;
        tk.actualZoneState = areaSt;
        tk.locationZone = areaSt.getLocation();
        this.tk = tk;
    }
    
    
}
