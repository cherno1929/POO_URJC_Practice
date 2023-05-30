/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ScreenTools;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;




/**
 *
 * @author Cherno
 */
public class Ticket {
    
    public List<Integer> rows = new ArrayList<Integer>();
    public List<Integer> cols = new ArrayList<Integer>();
    public String title;
    public String zona;
    public Date fecha;
    public int prize;
    public String locationZone;

    public String getInfo() {
        String info = "";
        
        info += "Entrada para : " + this.title + "\n";
        info += "Zona : " +  this.zona + "\n";

        for (int i = 0; i < this.cols.size(); i++){
            info += "Asiento nº "+ this.cols.get(i) +"; Fila : " + this.rows.get(i) + "\n";
        }
        
        DateFormat dayForm = new SimpleDateFormat("yyyy-MM-dd hh-mm");
        String fechDay = "Fecha : " + dayForm.format(fecha);
        
        info += fechDay + "\n";
        
        info += "Precio : " + this.prize +"€"+ "\n";
        
        return info;
    }
    
}
