/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TheaterTools;

/**
 *
 * @author Cherno
 */
public class TheaterAreaState implements Serializable{
    
    private SeatState[][] seatsState;
    private String name;
    private int cols;
    private int rows;
    
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
    
    //Contructor

    public TheaterAreaState(TheatherArea area) {
        
    }
    
}
