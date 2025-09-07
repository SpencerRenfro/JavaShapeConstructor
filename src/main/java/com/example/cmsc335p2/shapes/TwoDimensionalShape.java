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

    
    @Override
    public int getNumberOfDimensions() {
        return 2;
    }
}
