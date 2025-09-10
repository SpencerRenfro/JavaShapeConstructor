package com.example.cmsc335p2.shapes;

/**
 * Triangle class representing a triangular 2D shape
 */
public class Triangle extends TwoDimensionalShape {
    private double base;
    private double height;

    /**
     * Constructor for Triangle
     * @param base The base of the triangle
     * @param height The height of the triangle
     */
    public Triangle(double base, double height) {
        super("Triangle");
        this.base = base;
        this.height = height;
    }



    /**
     * Get the base of the triangle
     * @return The base
     */
    public double getBase() {
        return base;
    }

    /**
     * Set the base of the triangle
     * @param base The base
     */
    public void setBase(double base) {
        this.base = base;
    }

    /**
     * Get the height of the triangle
     * @return The height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Set the height of the triangle
     * @param height The height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }


}
