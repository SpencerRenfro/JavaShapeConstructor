package com.example.cmsc335p2.shapes;

/**
 * Abstract base class for all shapes
 * Provides common functionality and enforces implementation of area calculation
 */
public abstract class Shape {
    protected String name;
    protected String color;
    
    /**
     * Constructor for Shape
     * @param name The name of the shape
     */
    public Shape(String name) {
        this.name = name;
        this.color = "Blue"; // Default color
    }
    
    /**
     * Constructor for Shape with color
     * @param name The name of the shape
     * @param color The color of the shape
     */
    public Shape(String name, String color) {
        this.name = name;
        this.color = color;
    }
    
    /**
     * Abstract method to calculate area - must be implemented by subclasses
     * @return The area of the shape
     */
    public abstract double calculateArea();
    
    /**
     * Get the name of the shape
     * @return The shape name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Set the name of the shape
     * @param name The shape name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Get the color of the shape
     * @return The shape color
     */
    public String getColor() {
        return color;
    }
    
    /**
     * Set the color of the shape
     * @param color The shape color
     */
    public void setColor(String color) {
        this.color = color;
    }
    
    /**
     * Get the number of dimensions (2D or 3D)
     * @return Number of dimensions
     */
    public abstract int getNumberOfDimensions();
    
    @Override
    public String toString() {
        return String.format("%s (Color: %s, Area: %.2f)", name, color, calculateArea());
    }
}
