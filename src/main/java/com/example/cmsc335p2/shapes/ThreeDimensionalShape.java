package com.example.cmsc335p2.shapes;

/**
 * Abstract base class for three-dimensional shapes
 */
public abstract class ThreeDimensionalShape extends Shape {
    
    /**
     * Constructor for ThreeDimensionalShape
     * @param name The name of the shape
     */
    public ThreeDimensionalShape(String name) {
        super(name);
    }
    
    /**
     * Constructor for ThreeDimensionalShape with color
     * @param name The name of the shape
     * @param color The color of the shape
     */
    public ThreeDimensionalShape(String name, String color) {
        super(name, color);
    }
    
    @Override
    public int getNumberOfDimensions() {
        return 3;
    }
    
    /**
     * Abstract method to calculate volume - must be implemented by 3D shape subclasses
     * @return The volume of the shape
     */
    public abstract double calculateVolume();
    
    @Override
    public String toString() {
        return String.format("%s (Color: %s, Area: %.2f, Volume: %.2f)", 
                           name, color, calculateArea(), calculateVolume());
    }
}
