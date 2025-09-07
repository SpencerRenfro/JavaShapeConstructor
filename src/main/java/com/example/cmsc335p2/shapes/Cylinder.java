package com.example.cmsc335p2.shapes;

/**
 * Cylinder class representing a cylindrical 3D shape
 */
public class Cylinder extends ThreeDimensionalShape {
    private double radius;
    private double height;
    
    /**
     * Constructor for Cylinder
     * @param radius The radius of the cylinder base
     * @param height The height of the cylinder
     */
    public Cylinder(double radius, double height) {
        super("Cylinder");
        this.radius = radius;
        this.height = height;
    }
    

    
    /**
     * Get the radius of the cylinder
     * @return The radius
     */
    public double getRadius() {
        return radius;
    }
    
    /**
     * Set the radius of the cylinder
     * @param radius The radius
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    /**
     * Get the height of the cylinder
     * @return The height
     */
    public double getHeight() {
        return height;
    }
    
    /**
     * Set the height of the cylinder
     * @param height The height
     */
    public void setHeight(double height) {
        this.height = height;
    }
    
    @Override
    public double calculateArea() {
        // Surface area = 2πr(r + h)
        return 2 * Math.PI * radius * (radius + height);
    }
    
    @Override
    public double calculateVolume() {
        return Math.PI * radius * radius * height;
    }
    
    @Override
    public String toString() {
        return String.format("Cylinder (Radius: %.2f, Height: %.2f, Color: %s, Surface Area: %.2f, Volume: %.2f)", 
                           radius, height, color, calculateArea(), calculateVolume());
    }
}
