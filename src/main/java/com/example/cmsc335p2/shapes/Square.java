package com.example.cmsc335p2.shapes;

/**
 * Square class representing a square 2D shape
 */
public class Square extends TwoDimensionalShape {
    private double side;
    
    /**
     * Constructor for Square
     * @param side The side length of the square
     */
    public Square(double side) {
        super("Square");
        this.side = side;
    }
    
    /**
     * Constructor for Square with color
     * @param side The side length of the square
     * @param color The color of the square
     */
    public Square(double side, String color) {
        super("Square", color);
        this.side = side;
    }
    
    /**
     * Get the side length of the square
     * @return The side length
     */
    public double getSide() {
        return side;
    }
    
    /**
     * Set the side length of the square
     * @param side The side length
     */
    public void setSide(double side) {
        this.side = side;
    }
    
    @Override
    public double calculateArea() {
        return side * side;
    }
    
    /**
     * Calculate the perimeter of the square
     * @return The perimeter
     */
    public double calculatePerimeter() {
        return 4 * side;
    }
    
    @Override
    public String toString() {
        return String.format("Square (Side: %.2f, Color: %s, Area: %.2f)", 
                           side, color, calculateArea());
    }
}
