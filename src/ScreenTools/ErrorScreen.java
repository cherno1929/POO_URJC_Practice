/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ScreenTools;
import app_poo.DispenserManager;
import app_poo.Screen;
import app_poo.ScreenMode;
import app_poo.ScreenResult;
import urjc.UrjcBankServer;
/**
 *
 * @author Cherno
 */
public class ErrorScreen extends Screen{
    
    private UrjcBankServer bank = new UrjcBankServer();
    
    public ScreenResult end(){
        return null;
    }
    
    public ErrorScreen(DispenserManager dispenserManager, String title, ScreenMode mode) {
        super(dispenserManager, title, mode);
    }
    
    
}
