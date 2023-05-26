/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app_poo;

import TheaterTools.TheatherArea;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cherno
 */
public class Theater {
    
    private List<TheatherArea> theaterAreas = new ArrayList<TheatherArea>();
    private String image;
    
    //Methods
   public int getNumAreas(){
       return this.theaterAreas.size();
   }
   
   public TheatherArea getArea(int pos){
       return this.theaterAreas.get(pos);
   }
   
   private void read(String dir){
       
   }
   
}
