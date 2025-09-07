package com.example.cmsc335p2.shapes;

/**
 * Circle class representing a circular 2D shape
 */
public class Circle extends TwoDimensionalShape {
    private double radius;
    
    /**
     * Constructor for Circle
     * @param radius The radius of the circle
     */
    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }
    
    /**
     * Constructor for Circle with color
     * @param radius The radius of the circle
     * @param color The color of the circle
     */
    public Circle(double radius, String color) {
        super("Circle", color);
        this.radius = radius;
    }
    
    /**
     * Get the radius of the circle
     * @return The radius
     */
    public double getRadius() {
        return radius;
    }
    
    /**
     * Set the radius of the circle
     * @param radius The radius
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    /**
     * Calculate the circumference of the circle
     * @return The circumference
     */
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }
    
    @Override
    public String toString() {
        return String.format("Circle (Radius: %.2f, Color: %s, Area: %.2f)", 
                           radius, color, calculateArea());
    }
}
