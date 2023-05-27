/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ScreenTools;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cherno
 */
public class Play {
    
    private String title;
    private String image;
    private String desctiption;
    private String locationPlay = "DataFiles\\Theater\\play.txt";
    
    //Methods
    private void read(){
        try {
            BufferedReader playReader = new BufferedReader(new FileReader(this.locationPlay));
            String line;
            while((line = playReader.readLine()) != null) {
                String[] arr = line.split(":");
                String arrIdx = arr[0];
                String arrData = arr[1];
                if (arrIdx.equals("play_name")){
                    this.title = arrData;
                } else if (arrIdx.equals("play_poster")){
                    this.image = arrData;
                } else if (arrIdx.equals("description")){
                    this.desctiption = arrData;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Play.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public String getTitle() {
        return title;
    }

    public String getImage() {
        return this.locationPlay.substring(0,this.locationPlay.length() - 8) + image;
    }

    public String getDesctiption() {
        return desctiption;
    }
    
    //Construct

    public Play() {
        read();
    }
    
    
}
