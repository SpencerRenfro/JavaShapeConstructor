package com.example.cmsc335p2.shapes;

/**
 * Sphere class representing a spherical 3D shape
 */
public class Sphere extends ThreeDimensionalShape {
    private double radius;

    /**
     * Constructor for Sphere
     * @param radius The radius of the sphere
     */
    public Sphere(double radius) {
        super("Sphere");
        this.radius = radius;
    }



    /**
     * Get the radius of the sphere
     * @return The radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Set the radius of the sphere
     * @param radius The radius
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        // Surface area of sphere
        return 4 * Math.PI * radius * radius;
    }

    @Override
    public double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }


}
