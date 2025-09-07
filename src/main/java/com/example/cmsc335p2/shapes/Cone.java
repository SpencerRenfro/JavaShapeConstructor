package com.example.cmsc335p2.shapes;

/**
 * Cone class representing a conical 3D shape
 */
public class Cone extends ThreeDimensionalShape {
    private double radius;
    private double height;
    
    /**
     * Constructor for Cone
     * @param radius The radius of the cone base
     * @param height The height of the cone
     */
    public Cone(double radius, double height) {
        super("Cone");
        this.radius = radius;
        this.height = height;
    }
    
    /**
     * Constructor for Cone with color
     * @param radius The radius of the cone base
     * @param height The height of the cone
     * @param color The color of the cone
     */
    public Cone(double radius, double height, String color) {
        super("Cone", color);
        this.radius = radius;
        this.height = height;
    }
    
    /**
     * Get the radius of the cone
     * @return The radius
     */
    public double getRadius() {
        return radius;
    }
    
    /**
     * Set the radius of the cone
     * @param radius The radius
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    /**
     * Get the height of the cone
     * @return The height
     */
    public double getHeight() {
        return height;
    }
    
    /**
     * Set the height of the cone
     * @param height The height
     */
    public void setHeight(double height) {
        this.height = height;
    }
    
    @Override
    public double calculateArea() {
        // Surface area = π * r * (r + sqrt(h² + r²))
        double slantHeight = Math.sqrt(height * height + radius * radius);
        return Math.PI * radius * (radius + slantHeight);
    }
    
    @Override
    public double calculateVolume() {
        return (1.0 / 3.0) * Math.PI * radius * radius * height;
    }
    
    @Override
    public String toString() {
        return String.format("Cone (Radius: %.2f, Height: %.2f, Color: %s, Surface Area: %.2f, Volume: %.2f)", 
                           radius, height, color, calculateArea(), calculateVolume());
    }
}
