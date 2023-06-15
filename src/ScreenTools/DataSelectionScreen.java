/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ScreenTools;

import TheaterTools.SeatState;
import TheaterTools.TheaterAreaState;
import TheaterTools.TheaterState;
import TheaterTools.TheatherArea;
import app_poo.DispenserHardware;
import app_poo.DispenserManager;
import app_poo.Screen;
import app_poo.ScreenMode;
import app_poo.ScreenResult;
import app_poo.Theater;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cherno
 */
public class DataSelectionScreen extends Screen{
    
    private Map<Date,TheaterState> schedule = new HashMap<Date,TheaterState>();
    private AreaSelectionScreen areaScreen;
    private Theater theatr;
    private String loacionReservation = "DataFiles\\Reservations\\";
    
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
        this.asignSchedule(days);
        return days;
    }
    
    private void asignSchedule(List<Date> days) {
        for (Date day : days) {
            DateFormat formaterDate = new SimpleDateFormat("yyyy-MM-dd");
            this.schedule.put(day, this.loadStateFiles(this.loacionReservation + formaterDate.format(day)));
        }
    }
    
    public ScreenResult end(DispenserHardware harw) {
        return ScreenResult.exitScreen;
    }
    
    public ScreenResult optionButtonPressed(DispenserHardware hardw, char option){
        if (option != '0' && option != 'E'){
            int opt = (int) option;
        opt -= 65;
        
        List<Date> keys = new ArrayList<Date>(this.schedule.keySet());
        Collections.sort(keys);
        this.tk.fecha = keys.get(opt);

        this.areaScreen = new AreaSelectionScreen(this.tk,this.schedule.get(keys.get(opt)), dispenserManager, "Seleccione un Area", ScreenMode.optionsMode);
        this.dispenserManager.showScreen(30, areaScreen);
        return this.end(hardw);
        }else {
            return ScreenResult.exitScreen;
        }
    }
    
    public List<String> getOptions(){
        List<String> options = new ArrayList<String>();
        DateFormat dayCov = new SimpleDateFormat("yyyy-MM-dd");
        for (Date day : this.getDatesFromToday()){
            options.add(dayCov.format(day));
        }
        options.add("Salir");
        return options;
    }
    
    private TheaterState loadStateFiles(String fileLocation){
        TheaterState stateArea = null;
        File dayReservat = new File(fileLocation ); 
        
        if (dayReservat.exists()) {
            stateArea = readReservationFiles(dayReservat);
        } else {
            stateArea = createReservationFiles(dayReservat);
        }
        return stateArea;
    }
    
    private TheaterState createReservationFiles(File dayReserv){
        TheaterState state = new TheaterState(theatr, LocalDateTime.MAX);
        TheaterAreaState areaState = null;
        if (dayReserv.mkdir()) {
            for (TheatherArea area : this.theatr.getAreas()) {
                areaState = new TheaterAreaState(area);
                state.setAreaState(areaState);
                createNewFile(this.loacionReservation + dayReserv.getName() + "\\" + areaState.getName() + ".txt", areaState);
            }
        }
        return state;
    }
    
    private void createNewFile(String fileLocation, TheaterAreaState areaState) {
        String fileContnt = transformSeat_To_String(areaState);
        try {
            File crateArea = new File(fileLocation);
            if (crateArea.createNewFile()) {
                areaState.setLocation(crateArea.getAbsolutePath());
                BufferedWriter contentWriter = new BufferedWriter(new FileWriter(crateArea));
                contentWriter.write(fileContnt);
                contentWriter.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(DataSelectionScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String transformSeat_To_String(TheaterAreaState areaState) {
        String text = "";
        for (int i = 0; i < areaState.getRows(); i++) {
            int j = 0;
            while(j < areaState.getCols()) {
                if (areaState.getSeatsState()[i][j] == SeatState.free) {
                    text += "*";
                } else if (areaState.getSeatsState()[i][j] == SeatState.occupied){
                    text += "x";
                } else{
                    text += " ";
                }
                j += 1;
            }
            text += "\n";
        }
        return text;
    }
    
    private TheaterState readReservationFiles(File reserveFile) {
        TheaterState areas = new TheaterState(theatr, LocalDateTime.MAX);
        for (File reservt : reserveFile.listFiles()) {
            TheatherArea thArea = new TheatherArea(reservt.getAbsolutePath(), reservt.getName().substring(0, reservt.getName().length() - 4));
            TheaterAreaState area = new TheaterAreaState(thArea);
            area.setLocation(reservt.getAbsolutePath());
            areas.setAreaState(area);
        }
        return areas;
    }
    
    public ScreenResult begin(DispenserHardware dispHard){
        return ScreenResult.continueScreen;
    }
    
    public String getTitle(){
        return this.title;
    }
    
    //Construct
    public DataSelectionScreen(Theater theater, DispenserManager dispenserManager, String title, ScreenMode mode) {
        super(dispenserManager, title, mode);
        this.theatr = theater;

    }
    
    public DataSelectionScreen(Ticket tk,Theater theater, DispenserManager dispenserManager, String title, ScreenMode mode) {
        super(dispenserManager, title, mode);
        this.theatr = theater;
        this.tk = tk;
    }

    

    
    
}
