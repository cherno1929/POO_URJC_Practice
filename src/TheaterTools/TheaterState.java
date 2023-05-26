/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TheaterTools;

import app_poo.Theater;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Cherno
 */
public class TheaterState implements Serializable{
    private LocalDateTime date;
    private List<TheaterAreaState> areas;
    
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
    
    //Constructor

    public TheaterState(Theater theater, LocalDateTime date) {
        this.date = date;
    }
    
    
}
