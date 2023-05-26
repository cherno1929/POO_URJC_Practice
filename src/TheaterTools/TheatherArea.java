/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TheaterTools;

/**
 *
 * @author Cherno
 */
public class TheatherArea {
    
    private int rows;
    private int cols;
    private String name;
    private SeatState[][] seats;
    private int prize;
    
    //Methods

    public SeatState getSeat(int row, int col){
        return this.seats[row][col];
    }
    
    private void read(String fileName){
        
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

    public TheatherArea(String fileName) {
        read(fileName);
    }
    
}
