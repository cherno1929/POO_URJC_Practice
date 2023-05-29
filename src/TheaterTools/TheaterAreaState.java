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
    private int price;
    
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

    public SeatState[][] getSeatsState() {
        return seatsState;
    }

    public void setSeatsState(SeatState[][] seatsState) {
        this.seatsState = seatsState;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
    
    //Contructor

    public TheaterAreaState(TheatherArea area) {
        this.cols = area.getCols();
        this.name = area.getName();
        this.rows = area.getRows();
        this.price = area.getPrize();
        this.seatsState = area.getSeats();
    }

    public void fillSeat(int row, int col) {
        this.seatsState[row][col] = SeatState.occupied;
    }
    
}
