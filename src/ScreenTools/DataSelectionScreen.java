/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ScreenTools;

import TheaterTools.TheaterState;
import app_poo.DispenserHardware;
import app_poo.DispenserManager;
import app_poo.Screen;
import app_poo.ScreenMode;
import app_poo.ScreenResult;
import app_poo.Theater;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Cherno
 */
public class DataSelectionScreen extends Screen{
    
    private Map schedule = new HashMap<Date,TheaterState>();
    private AreaSelectionScreen areaScreen;
    
    //Methods
    private List<Date> getDatesFromToday(){
        List<Date> days = new ArrayList<Date>();
        Date nowDate = new Date();
        Calendar dateControll = Calendar.getInstance();
        days.add(nowDate);
        for (int i = 0; i < 3; i++) {
            dateControll.setTime(nowDate);
            dateControll.add(Calendar.DATE, 1);
            nowDate = dateControll.getTime();
            days.add(nowDate);
        }
        return days;
    }
    
    
    public List<String> getOptions(){
        List<String> options = new ArrayList<String>();
        DateFormat dayCov = new SimpleDateFormat("yyyy-MM-dd");
        for (Date day : this.getDatesFromToday()){
            options.add(dayCov.format(day));
        }
        return options;
    }
    
    private void loadStateFiles(){
        
    }
    
    public ScreenResult begin(DispenserHardware dispHard){
        this.loadStateFiles();
        return ScreenResult.continueScreen;
    }
    
    public String getTitle(){
        return this.title;
    }
    
    //Construct
    public DataSelectionScreen(Theater theater, DispenserManager dispenserManager, String title, ScreenMode mode) {
        super(dispenserManager, title, mode);
    }
    
}
