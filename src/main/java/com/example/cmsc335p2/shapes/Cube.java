package com.example.cmsc335p2.shapes;

/**
 * Cube class representing a cubic 3D shape
 */
public class Cube extends ThreeDimensionalShape {
    private double side;
    
    /**
     * Constructor for Cube
     * @param side The side length of the cube
     */
    public Cube(double side) {
        super("Cube");
        this.side = side;
    }
    

    /**
     * Get the side length of the cube
     * @return The side length
     */
    public double getSide() {
        return side;
    }
    
    /**
     * Set the side length of the cube
     * @param side The side length
     */
    public void setSide(double side) {
        this.side = side;
    }
    
    @Override
    public double calculateArea() {
        // Surface area of cube (6 faces)
        return 6 * side * side;
    }
    
    @Override
    public double calculateVolume() {
        return side * side * side;
    }
    
    @Override
    public String toString() {
        return String.format("Cube (Side: %.2f, Color: %s, Surface Area: %.2f, Volume: %.2f)", 
                           side, color, calculateArea(), calculateVolume());
    }
}
