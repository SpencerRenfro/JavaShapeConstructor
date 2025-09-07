package com.example.cmsc335p2.shapes;

/**
 * Torus class representing a torus (donut-shaped) 3D shape
 */
public class Torus extends ThreeDimensionalShape {
    private double majorRadius; // Distance from center of torus to center of tube
    private double minorRadius; // Radius of the tube
    
    /**
     * Constructor for Torus
     * @param majorRadius The major radius (distance from center to tube center)
     * @param minorRadius The minor radius (tube radius)
     */
    public Torus(double majorRadius, double minorRadius) {
        super("Torus");
        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;
    }
    
    /**
     * Constructor for Torus with color
     * @param majorRadius The major radius (distance from center to tube center)
     * @param minorRadius The minor radius (tube radius)
     * @param color The color of the torus
     */
    public Torus(double majorRadius, double minorRadius, String color) {
        super("Torus", color);
        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;
    }
    
    /**
     * Get the major radius of the torus
     * @return The major radius
     */
    public double getMajorRadius() {
        return majorRadius;
    }
    
    /**
     * Set the major radius of the torus
     * @param majorRadius The major radius
     */
    public void setMajorRadius(double majorRadius) {
        this.majorRadius = majorRadius;
    }
    
    /**
     * Get the minor radius of the torus
     * @return The minor radius
     */
    public double getMinorRadius() {
        return minorRadius;
    }
    
    /**
     * Set the minor radius of the torus
     * @param minorRadius The minor radius
     */
    public void setMinorRadius(double minorRadius) {
        this.minorRadius = minorRadius;
    }
    
    @Override
    public double calculateArea() {
        // Surface area = 4π²Rr where R is major radius, r is minor radius
        return 4 * Math.PI * Math.PI * majorRadius * minorRadius;
    }
    
    @Override
    public double calculateVolume() {
        // Volume = 2π²Rr² where R is major radius, r is minor radius
        return 2 * Math.PI * Math.PI * majorRadius * minorRadius * minorRadius;
    }
    
    @Override
    public String toString() {
        return String.format("Torus (Major Radius: %.2f, Minor Radius: %.2f, Color: %s, Surface Area: %.2f, Volume: %.2f)", 
                           majorRadius, minorRadius, color, calculateArea(), calculateVolume());
    }
}
