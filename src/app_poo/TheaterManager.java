/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app_poo;

import ScreenTools.WellcomeScreen;

/**
 *
 * @author Cherno
 */
public class TheaterManager {

    public void run() {
        DispenserManager dispMang = new DispenserManager();
        Theater theater = new Theater();
        Screen wlScreen = new WellcomeScreen(theater,dispMang,null,ScreenMode.theaterMode);
        dispMang.showScreen(30, wlScreen);
    }
    
}
