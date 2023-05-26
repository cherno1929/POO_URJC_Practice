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
import urjc.UrjcBankServer;

/**
 *
 * @author Cherno
 */
public class PaymentScreen extends Screen{
    
    private UrjcBankServer bank = new UrjcBankServer();
    private int price;
    
    //Methods

    public ScreenResult optionButtonPressed(char c){
        return null;
    }
    
    public ScreenResult creditCardDetected(DispenserHardware d){
        return null;     
    }
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    //Costruct
    public PaymentScreen(DispenserManager dispenserManager, String title, ScreenMode mode) {
        super(dispenserManager, title, mode);
    }

    public PaymentScreen(int amount, String resume,DispenserManager dispenserManager, String title, ScreenMode mode) {
        super(dispenserManager, title, mode);
        this.price = amount;
    }
    
     
    
}
