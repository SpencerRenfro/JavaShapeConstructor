/**
 * FileName: ShapeFactory.java
 * Date: September 7, 2025
 * Author: Spencer Renfro
 * Purpose: This is a factory class that creates shape objects based on the type of shape and the dimensions provided.
 */

package com.example.cmsc335p2;

import com.example.cmsc335p2.shapes.*;

/**
 * Factory class for creating shape instances
 * Provides methods to create shapes with specified dimensions
 */
public class ShapeFactory {
    
    /**
     * Create a shape based on type and dimensions
     * @param shapeType The type of shape to create
     * @param dimensions Array of dimensions
     * @return The created shape instance
     */
    public static Shape createShape(String shapeType, double[] dimensions) {
        String color = "Blue"; // Default color
        switch (shapeType.toLowerCase()) {
            case "circle":
                return new Circle(dimensions[0]);
            case "square":
                return new Square(dimensions[0]);
            case "triangle":
                return new Triangle(dimensions[0], dimensions[1]);
            case "rectangle":
                return new Rectangle(dimensions[0], dimensions[1]);
            case "sphere":
                return new Sphere(dimensions[0]);
            case "cube":
                return new Cube(dimensions[0]);
            case "cone":
                return new Cone(dimensions[0], dimensions[1]);
            case "cylinder":
                return new Cylinder(dimensions[0], dimensions[1]);
            case "torus":
                return new Torus(dimensions[0], dimensions[1]);
            default:
                return null;
        }
    }
    
    /**
     * Get the required number of dimensions for a shape type
     * @param shapeType The type of shape
     * @return Number of dimensions required
     */
    public static int getRequiredDimensions(String shapeType) {
        switch (shapeType.toLowerCase()) {
            case "circle":
            case "square":
            case "sphere":
            case "cube":
                return 1;
            case "triangle":
            case "rectangle":
            case "cone":
            case "cylinder":
            case "torus":
                return 2;
            default:
                return 0;
        }
    }
    
    /**
     * Get dimension labels for a shape type
     * @param shapeType The type of shape
     * @return Array of dimension labels
     */
    public static String[] getDimensionLabels(String shapeType) {
        switch (shapeType.toLowerCase()) {
            case "circle":
                return new String[]{"Radius"};
            case "square":
                return new String[]{"Side Length"};
            case "triangle":
                return new String[]{"Base", "Height"};
            case "rectangle":
                return new String[]{"Width", "Height"};
            case "sphere":
                return new String[]{"Radius"};
            case "cube":
                return new String[]{"Side Length"};
            case "cone":
                return new String[]{"Radius", "Height"};
            case "cylinder":
                return new String[]{"Radius", "Height"};
            case "torus":
                return new String[]{"Major Radius", "Minor Radius"};
            default:
                return new String[]{};
        }
    }

}
