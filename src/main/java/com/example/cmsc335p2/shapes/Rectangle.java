package com.example.cmsc335p2.shapes;

/**
 * Rectangle class representing a rectangular 2D shape
 */
public class Rectangle extends TwoDimensionalShape {
    private double width;
    private double height;
    
    /**
     * Constructor for Rectangle
     * @param width The width of the rectangle
     * @param height The height of the rectangle
     */
    public Rectangle(double width, double height) {
        super("Rectangle");
        this.width = width;
        this.height = height;
    }
    

    
    /**
     * Get the width of the rectangle
     * @return The width
     */
    public double getWidth() {
        return width;
    }
    
    /**
     * Set the width of the rectangle
     * @param width The width
     */
    public void setWidth(double width) {
        this.width = width;
    }
    
    /**
     * Get the height of the rectangle
     * @return The height
     */
    public double getHeight() {
        return height;
    }
    
    /**
     * Set the height of the rectangle
     * @param height The height
     */
    public void setHeight(double height) {
        this.height = height;
    }
    
    @Override
    public double calculateArea() {
        return width * height;
    }
    
    /**
     * Calculate the perimeter of the rectangle
     * @return The perimeter
     */
    public double calculatePerimeter() {
        return 2 * (width + height);
    }
    
    @Override
    public String toString() {
        return String.format("Rectangle (Width: %.2f, Height: %.2f, Color: %s, Area: %.2f)", 
                           width, height, color, calculateArea());
    }
}
