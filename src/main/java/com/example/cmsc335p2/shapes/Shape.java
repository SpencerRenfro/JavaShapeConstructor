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
     * Get the number of dimensions (2D or 3D)
     * @return Number of dimensions
     */
    public abstract int getNumberOfDimensions();

}
