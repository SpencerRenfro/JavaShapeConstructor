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



    @Override
    public int getNumberOfDimensions() {
        return 3;
    }

    /**
     * Abstract method to calculate volume - must be implemented by 3D shape subclasses
     * @return The volume of the shape
     */
    public abstract double calculateVolume();


}
