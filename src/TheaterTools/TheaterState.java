/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TheaterTools;

import app_poo.Theater;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Cherno
 */
public class TheaterState implements Serializable{
    private LocalDateTime date;
    private List<TheaterAreaState> areas = new ArrayList<TheaterAreaState>();
    
    //Methods

    public LocalDateTime getDate() {
        return date;
    }

    public TheaterAreaState getArea(int pos) {
        return this.areas.get(pos);
    }
    
    public int getNumAreas(){
        return this.areas.size();
    }

    public List<TheaterAreaState> getAreas() {
        return areas;
    }

    public void setAreas(TheaterAreaState areas) {
        this.areas.add(areas);
    }
    
    
    
    //Constructor

    public TheaterState(Theater theater, LocalDateTime date) {
        this.date = date;
    }

    public void setAreaState(TheaterAreaState areaState) {
        this.areas.add(areaState);
    }


    
}
