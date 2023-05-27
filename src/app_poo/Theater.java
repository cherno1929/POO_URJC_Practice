/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app_poo;

import TheaterTools.TheatherArea;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cherno
 */
public class Theater {
    
    private List<TheatherArea> theaterAreas = new ArrayList<TheatherArea>();
    private String image;
    private String locationTheater = "DataFiles\\Theater\\theater.txt";
    private String theaterPlay;
    
    //Methods
   public int getNumAreas(){
       return this.theaterAreas.size();
   }
   
   public TheatherArea getArea(int pos){
       return this.theaterAreas.get(pos);
   }
   
   private void read(String dir){
        try {
            BufferedReader readerTheater = new BufferedReader(new FileReader(dir));
            String line;
            while ((line = readerTheater.readLine()) != null) {
                String[] arr = line.split(":");
                String arrIdx = arr[0];
                String arrData = arr[1];
                if (arrIdx.equals("Area")) {
                   TheatherArea area = new TheatherArea(arrData);
                   this.theaterAreas.add(area);
                } else if (arrIdx.equals("TheaterPlaneImageFile")){
                    this.image = arrData;
                }
            }
            readerTheater.close();
        } catch (IOException ex) {
            Logger.getLogger(Theater.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   //Construct

    public Theater() {
        read(this.locationTheater);
    }
   
   
}
