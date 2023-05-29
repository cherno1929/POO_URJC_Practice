/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TheaterTools;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cherno
 */
public class TheatherArea {
    
    private int rows = 0;
    private int cols = 0;
    private String name;
    private SeatState[][] seats;
    private int prize;
    private String locationZone = "DataFiles\\Zonas\\";
    
    //Methods

    public SeatState getSeat(int row, int col){
        return this.seats[row][col];
    }
    
    public void read(String fileName){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.length() > this.cols){this.cols = line.length();}
                this.rows++;
            }
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger(TheatherArea.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.seats = new SeatState[rows][cols];
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == '*') {
                        this.seats[row][i] = SeatState.free;
                    } else if(line.charAt(i) == 'x') {
                        this.seats[row][i] = SeatState.occupied;
                    }
                }
                row++;
            }
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger(TheatherArea.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public String getName() {
        return name;
    }

    public SeatState[][] getSeats() {
        return seats;
    }

    public int getPrize() {
        return prize;
    }
    
    //Constructor

    public TheatherArea(String data) { // Example Palco1;30€;palco1.txt
        String[] arrData = data.split(";");
        this.name = arrData[0];
        String[] arrPrecio = arrData[1].split("€");
        this.prize = Integer.parseInt(arrPrecio[0]);
        read(this.locationZone + arrData[2]);
    }
    
    public TheatherArea(String data, String nom) { 
        this.name = nom;
        read(data);
    }
    
}
