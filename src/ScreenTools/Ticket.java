/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ScreenTools;

import TheaterTools.TheaterAreaState;
import app_poo.TranslatorManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;




/**
 *
 * @author Cherno
 */
public class Ticket {
    
    public List<Integer> rows = new ArrayList<Integer>();
    public List<Integer> cols = new ArrayList<Integer>();
    public Map<String,List<Integer>> nonSelectedRow = new TreeMap<String,List<Integer>>();
    public Map<String,List<Integer>> nonSelectedCol = new TreeMap<String,List<Integer>>();
    public String title;
    public String zona;
    public TheaterAreaState actualZoneState;
    public Date fecha;
    public int prize;
    public String locationZone;
    public TranslatorManager tMnag;

    Ticket(TranslatorManager translator) {
        this.tMnag = translator;
    }

    public String getInfo() {
        String info = "";
        
        info += this.tMnag.translate("Entrada para")+" : " + this.tMnag.translate(this.title) + "\n";
        info += this.tMnag.translate("Zona") +" : " +  this.tMnag.translate(this.zona ) + "\n";

        for (int i = 0; i < this.cols.size(); i++){
            info += this.tMnag.translate("Asiento")+" nº "+ this.cols.get(i) +" - "+this.tMnag.translate("Fila")+" : " + this.rows.get(i) + "\n";
        }
        
        info += getCanceledSeats();
        
        DateFormat dayForm = new SimpleDateFormat("yyyy-MM-dd hh-mm");
        String fechDay = this.tMnag.translate("Fecha")+ " : " + dayForm.format(fecha);
        
        info += fechDay + "\n";
        
        info += this.tMnag.translate("Precio") + " : " + this.prize +"€"+ "\n";
        
        return info;
    }
    
    private String getCanceledSeats(){
        String info_Aux = "------------\n";
        
        if (this.nonSelectedCol.size() > 0){
            info_Aux += "Cancelados :: \n";
            for (String key : this.nonSelectedCol.keySet()) {
                info_Aux += "Zona :: " + key + "\n";
            for (int i = 0; i < this.nonSelectedCol.get(key).size(); i++) {
                info_Aux += this.tMnag.translate("Asiento")+" nº "+ this.nonSelectedCol.get(key).get(i) +" - "+this.tMnag.translate("Fila")+" : " + this.nonSelectedRow.get(key).get(i) + "\n";
            }
        }
            info_Aux += "------------\n";
        }
        
        return info_Aux;
    }
    
}
