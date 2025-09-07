package com.example.cmsc335p2.shapes;

/**
 * Abstract base class for two-dimensional shapes
 */
public abstract class TwoDimensionalShape extends Shape {
    
    /**
     * Constructor for TwoDimensionalShape
     * @param name The name of the shape
     */
    public TwoDimensionalShape(String name) {
        super(name);
    }
    
    /**
     * Constructor for TwoDimensionalShape with color
     * @param name The name of the shape
     * @param color The color of the shape
     */
    public TwoDimensionalShape(String name, String color) {
        super(name, color);
    }
    
    @Override
    public int getNumberOfDimensions() {
        return 2;
    }
}
