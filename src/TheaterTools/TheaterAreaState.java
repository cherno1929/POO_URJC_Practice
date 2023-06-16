/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TheaterTools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cherno
 */
public class TheaterAreaState implements Serializable{
    
    private SeatState[][] seatsState;
    private String locationPrice = "DataFiles\\Theater\\theater.txt";
    private String location;
    private String name;
    private int cols;
    private int rows;
    private int price;
    
    //Methods
    
    public SeatState getSeatsState(int row, int col) {
        return this.seatsState[row][col];
    }
    
    public void setSeat(int row, int col, SeatState state){
        this.seatsState[row][col] = state;
    }

    public String getName() {
        return name;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public SeatState[][] getSeatsState() {
        return seatsState;
    }

    public void setSeatsState(SeatState[][] seatsState) {
        this.seatsState = seatsState;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public void searchPrice() {
        File locatPr = new File(this.locationPrice);
        try {
            BufferedReader priceReader = new BufferedReader(new FileReader(locatPr));
            String line;
            line = priceReader.readLine();
            line = priceReader.readLine();
            while((line = priceReader.readLine()) != null) {
                String[]  arr = line.split(";");
                String[] arrName = arr[0].split(":");
                if (arrName[1].equals( this.name)) {
                    String[] arrPr = arr[1].split("€");
                    this.price = Integer.parseInt(arrPr[0]);
                    break;                }
            }
        } catch (IOException ex) {
            Logger.getLogger(TheaterAreaState.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
        .atZone(ZoneId.systemDefault())
        .toLocalDateTime();
    }
    
    
        
    public void searchPrice(Date fecha) {
        LocalDateTime localDay = convertToLocalDateTimeViaInstant(fecha);
        String dayWeek = localDay.getDayOfWeek().name();
        File locatPr = new File(this.locationPrice);
        try {
            BufferedReader priceReader = new BufferedReader(new FileReader(locatPr));
            String line;
            line = priceReader.readLine();
            line = priceReader.readLine();
            if (dayWeek == "FRIDAY" || dayWeek == "SATURDAY" || dayWeek == "SUNDAY") {
                while((line = priceReader.readLine()) != null) {
                String[]  arr = line.split(";");
                String[] arrName = arr[0].split(":");
                if (arrName[1].equals( this.name) && arrName[0].equals("Festivo")) {
                    String[] arrPr = arr[1].split("€");
                    this.price = Integer.parseInt(arrPr[0]);
                    break;                }
            }
            } else {
                while((line = priceReader.readLine()) != null) {
                String[]  arr = line.split(";");
                String[] arrName = arr[0].split(":");
                if (arrName[1].equals( this.name)) {
                    String[] arrPr = arr[1].split("€");
                    this.price = Integer.parseInt(arrPr[0]);
                    break;                }
            }
            }
        } catch (IOException ex) {
            Logger.getLogger(TheaterAreaState.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    
    
    public void fillSeat(int row, int col) {
        this.seatsState[row][col] = SeatState.occupied;
    }
    
    public void unFillSeat(int row, int col) {
        this.seatsState[row][col] = SeatState.free;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    
    
    //Contructor

    public TheaterAreaState(TheatherArea area) {
        this.cols = area.getCols();
        this.name = area.getName();
        this.rows = area.getRows();
        this.price = area.getPrize();
        this.seatsState = area.getSeats();
    }

    

    

    
    
}
