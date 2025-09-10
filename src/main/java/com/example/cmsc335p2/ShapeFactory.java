/**
 * FileName: ShapeFactory.java
 * Date: September 7, 2025
 * Author: Spencer Renfro
 * Purpose: Factory class that creates shape objects based on type and dimensions.
 */

package com.example.cmsc335p2;

import com.example.cmsc335p2.shapes.*;

/**
 * Factory class for creating shape instances
 */
public class ShapeFactory {
    
    /**
     * Create a shape based on type and dimensions
     */
    public static Shape createShape(String shapeType, double[] dimensions) {
        String color = "Blue"; // Default color
        return switch (shapeType.toLowerCase()) {
            case "circle" -> new Circle(dimensions[0]);
            case "square" -> new Square(dimensions[0]);
            case "triangle" -> new Triangle(dimensions[0], dimensions[1]);
            case "rectangle" -> new Rectangle(dimensions[0], dimensions[1]);
            case "sphere" -> new Sphere(dimensions[0]);
            case "cube" -> new Cube(dimensions[0]);
            case "cone" -> new Cone(dimensions[0], dimensions[1]);
            case "cylinder" -> new Cylinder(dimensions[0], dimensions[1]);
            case "torus" -> new Torus(dimensions[0], dimensions[1]);
            default -> null;
        };
    }
    
    /**
     * Get the required number of dimensions for a shape type
     */
    public static int getRequiredDimensions(String shapeType) {
        return switch (shapeType.toLowerCase()) {
            case "circle", "square", "sphere", "cube" -> 1;
            case "triangle", "rectangle", "cone", "cylinder", "torus" -> 2;
            default -> 0;
        };
    }
    
    /**
     * Get dimension labels for a shape type
     */
    public static String[] getDimensionLabels(String shapeType) {
        return switch (shapeType.toLowerCase()) {
            case "circle" -> new String[]{"Radius"};
            case "square" -> new String[]{"Side Length"};
            case "triangle" -> new String[]{"Base", "Height"};
            case "rectangle" -> new String[]{"Width", "Height"};
            case "sphere" -> new String[]{"Radius"};
            case "cube" -> new String[]{"Side Length"};
            case "cone" -> new String[]{"Radius", "Height"};
            case "cylinder" -> new String[]{"Radius", "Height"};
            case "torus" -> new String[]{"Major Radius", "Minor Radius"};
            default -> new String[]{};
        };
    }

}
