package com.example.cmsc335p2;

import com.example.cmsc335p2.shapes.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for verifying that 2D shapes can be resized using their setter methods
 */
public class ShapeResizeTest {

    @Test
    public void testCircleResize() {
        Circle circle = new Circle(10.0);
        assertEquals(10.0, circle.getRadius(), 0.001);
        
        // Test resizing
        circle.setRadius(20.0);
        assertEquals(20.0, circle.getRadius(), 0.001);
        
        // Verify area is recalculated correctly
        double expectedArea = Math.PI * 20.0 * 20.0;
        assertEquals(expectedArea, circle.calculateArea(), 0.001);
    }

    @Test
    public void testSquareResize() {
        Square square = new Square(10.0);
        assertEquals(10.0, square.getSide(), 0.001);
        
        // Test resizing
        square.setSide(15.0);
        assertEquals(15.0, square.getSide(), 0.001);
        
        // Verify area is recalculated correctly
        assertEquals(225.0, square.calculateArea(), 0.001);
    }

    @Test
    public void testRectangleResize() {
        Rectangle rectangle = new Rectangle(10.0, 20.0);
        assertEquals(10.0, rectangle.getWidth(), 0.001);
        assertEquals(20.0, rectangle.getHeight(), 0.001);
        
        // Test resizing width
        rectangle.setWidth(15.0);
        assertEquals(15.0, rectangle.getWidth(), 0.001);
        assertEquals(20.0, rectangle.getHeight(), 0.001);
        
        // Test resizing height
        rectangle.setHeight(25.0);
        assertEquals(15.0, rectangle.getWidth(), 0.001);
        assertEquals(25.0, rectangle.getHeight(), 0.001);
        
        // Verify area is recalculated correctly
        assertEquals(375.0, rectangle.calculateArea(), 0.001);
    }

    @Test
    public void testTriangleResize() {
        Triangle triangle = new Triangle(10.0, 8.0);
        assertEquals(10.0, triangle.getBase(), 0.001);
        assertEquals(8.0, triangle.getHeight(), 0.001);
        
        // Test resizing base
        triangle.setBase(12.0);
        assertEquals(12.0, triangle.getBase(), 0.001);
        assertEquals(8.0, triangle.getHeight(), 0.001);
        
        // Test resizing height
        triangle.setHeight(10.0);
        assertEquals(12.0, triangle.getBase(), 0.001);
        assertEquals(10.0, triangle.getHeight(), 0.001);
        
        // Verify area is recalculated correctly
        assertEquals(60.0, triangle.calculateArea(), 0.001);
    }

    @Test
    public void testShapeFactoryCreatesCorrectShapes() {
        // Test that ShapeFactory creates shapes with correct initial dimensions
        Shape circle = ShapeFactory.createShape("Circle", new double[]{5.0});
        assertTrue(circle instanceof Circle);
        assertEquals(5.0, ((Circle) circle).getRadius(), 0.001);
        
        Shape square = ShapeFactory.createShape("Square", new double[]{7.0});
        assertTrue(square instanceof Square);
        assertEquals(7.0, ((Square) square).getSide(), 0.001);
        
        Shape rectangle = ShapeFactory.createShape("Rectangle", new double[]{4.0, 6.0});
        assertTrue(rectangle instanceof Rectangle);
        assertEquals(4.0, ((Rectangle) rectangle).getWidth(), 0.001);
        assertEquals(6.0, ((Rectangle) rectangle).getHeight(), 0.001);
        
        Shape triangle = ShapeFactory.createShape("Triangle", new double[]{8.0, 5.0});
        assertTrue(triangle instanceof Triangle);
        assertEquals(8.0, ((Triangle) triangle).getBase(), 0.001);
        assertEquals(5.0, ((Triangle) triangle).getHeight(), 0.001);
    }
}
