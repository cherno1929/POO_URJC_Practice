/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app_poo;

/**
 *
 * @author Cherno
 */
public class DispenserHardware {
    
    private sienens.TheaterTicketDispenser dispenser = new sienens.TheaterTicketDispenser();
    
    //Methods
    
    public void printTicket(String ticket){
        
    }
    
    public void retainCreditCard(boolean bloq){
        this.dispenser.retainCreditCard(bloq);
    }
    
    public void extpelCreditCard(){
        this.dispenser.expelCreditCard(0);
    }
    
    public long getCardNumber() {
        return this.dispenser.getCardNumber();
    }
}
