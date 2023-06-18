/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ScreenTools;

import app_poo.DispenserHardware;
import app_poo.DispenserManager;
import app_poo.Screen;
import app_poo.ScreenMode;
import app_poo.ScreenResult;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.CommunicationException;
import urjc.UrjcBankServer;

/**
 *
 * @author Cherno
 */
public class PaymentScreen extends Screen{
    
    private UrjcBankServer bank = new UrjcBankServer();
    private SeatSelectionScreen selctSrc;
    private int price;
    
    //Methods

    public ScreenResult optionButtonPressed(char c){
        return null;
    }
    
    public List<String> getOptions(){
        List<String> options = new ArrayList<String>();
        
        options.add("Salir");
        options.add("Terminar");
       
        return options;
    }
    
    
    public ScreenResult creditCardDetected(DispenserHardware d){
        return null;     
    }
    
   
    
    public ScreenResult optionButtonPressed(DispenserHardware dispHardw, char option) {
        if (option == '0' || option == 'A'){
            this.tk.transferNotSelected();
            return ScreenResult.exitScreen;
        }else if (option == '1') {
            long creditCard = this.dispenserManager.retainCard();
            try {
                this.bank.doOperation(creditCard, price);
                this.dispenserManager.printScreen(this.tk.getInfo());
                this.selctSrc.modifyZone(this.tk);
                this.tk.resetTichet();
                this.dispenserManager.explelCard();
                return ScreenResult.exitScreen;
            } catch (CommunicationException ex) {
                Logger.getLogger(PaymentScreen.class.getName()).log(Level.SEVERE, null, ex);
                return ScreenResult.continueScreen;
            }
        } else{
            return ScreenResult.continueScreen;
        }
    }
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public ScreenResult begin(DispenserHardware dispHardw) {
        if (this.bank.comunicationAvaiable()) {
            return ScreenResult.continueScreen;
        }else{
            return ScreenResult.exitScreen;
        }
    }
    
    public String getDescription(){
        return this.tk.getInfo();
    }
    
    //Costruct

    public PaymentScreen(SeatSelectionScreen selctScr,Ticket tk,int amount, String resume,DispenserManager dispenserManager, String title, ScreenMode mode) {
        super(dispenserManager, title, mode);
        tk.prize = amount;
        this.tk = tk;
        this.price = amount;
        this.selctSrc = selctScr;
    }
    
     
    
}
