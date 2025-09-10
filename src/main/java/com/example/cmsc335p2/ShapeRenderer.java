/**
 * FileName: ShapeRenderer.java
 * Date: September 7, 2025
 * Author: Spencer Renfro
 * Purpose: Utility class for rendering 2D and 3D shapes on a JavaFX Canvas.
 */
package com.example.cmsc335p2;

import com.example.cmsc335p2.shapes.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;

import java.util.Objects;

import static javafx.scene.paint.Color.BLUE;

/**
 * Utility class for rendering shapes on a JavaFX Canvas
 */
public class ShapeRenderer {

    /**
     * Render a shape on the given graphics context
     */
    public static void renderShape(GraphicsContext gc, Shape shape, double centerX, double centerY) {
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);


        if (shape instanceof Circle) {
            renderCircle(gc, (Circle) shape, centerX, centerY);
        } else if (shape instanceof Square) {
            renderSquare(gc, (Square) shape, centerX, centerY);
        } else if (shape instanceof Triangle) {
            renderTriangle(gc, (Triangle) shape, centerX, centerY);
        } else if (shape instanceof Rectangle) {
            renderRectangle(gc, (Rectangle) shape, centerX, centerY);
        } else if (shape instanceof Sphere) {
            renderSphere(gc, (Sphere) shape, centerX, centerY);
        } else if (shape instanceof Cube) {
            renderCube(gc, (Cube) shape, centerX, centerY);
        } else if (shape instanceof Cone) {
            renderCone(gc, (Cone) shape, centerX, centerY);
        } else if (shape instanceof Cylinder) {
            renderCylinder(gc, (Cylinder) shape, centerX, centerY);
        } else if (shape instanceof Torus) {
            renderTorus(gc, (Torus) shape, centerX, centerY);
        }
    }

    private static void renderCircle(GraphicsContext gc, Circle circle, double centerX, double centerY) {
        double radius = circle.getRadius();
        renderImageShape(gc, "circle.png", radius * 2, centerX, centerY);
    }

    private static void renderSquare(GraphicsContext gc, Square square, double centerX, double centerY) {
        double side = square.getSide();
        renderImageShape(gc, "square.png", side, centerX, centerY);
   }

    private static void renderTriangle(GraphicsContext gc, Triangle triangle, double centerX, double centerY) {
        double base = triangle.getBase();
        double height = triangle.getHeight();
        renderImageShape(gc, "triangle.png", base, centerX, centerY);
    }

    private static void renderRectangle(GraphicsContext gc, Rectangle rectangle, double centerX, double centerY) {
        double width = rectangle.getWidth();
        double height = rectangle.getHeight();
        double size = Math.max(width, height);
        renderImageShape(gc, "rectangle.png", size,  centerX, centerY);
    }

    private static void renderSphere(GraphicsContext gc, Sphere sphere, double centerX, double centerY) {
        renderImageShape(gc, "sphere.png", sphere.getRadius() * 2, centerX, centerY);
    }

    private static void renderCube(GraphicsContext gc, Cube cube, double centerX, double centerY) {
        renderImageShape(gc, "cube.png", cube.getSide(), centerX, centerY);
    }

    private static void renderCone(GraphicsContext gc, Cone cone, double centerX, double centerY) {
        double size = Math.max(cone.getRadius() * 2, cone.getHeight());
        renderImageShape(gc, "cone.png", size, centerX, centerY);
    }

    private static void renderCylinder(GraphicsContext gc, Cylinder cylinder, double centerX, double centerY) {
        double size = Math.max(cylinder.getRadius() * 2, cylinder.getHeight());
        renderImageShape(gc, "cylinder.png", size, centerX, centerY);
    }

    private static void renderTorus(GraphicsContext gc, Torus torus, double centerX, double centerY) {
        double size = (torus.getMajorRadius() + torus.getMinorRadius()) * 2;
        renderImageShape(gc, "torus.png", size, centerX, centerY);
    }

    private static void renderImageShape(GraphicsContext gc, String imageName, double size, double centerX, double centerY) {
            Image image = new Image(Objects.requireNonNull(ShapeRenderer.class.getResourceAsStream("/com/example/cmsc335p2/images/" + imageName)));
            gc.drawImage(image, centerX - size/2, centerY - size/2, size, size);
    }

}