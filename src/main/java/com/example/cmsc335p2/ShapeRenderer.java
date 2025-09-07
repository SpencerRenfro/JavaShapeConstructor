/**
 * FileName: ShapeRenderer.java
 * Date: September 7, 2025
 * Author: Spencer Renfro
 * Purpose: Utility class for rendering both 2D and 3D shapes onto a JavaFX Canvas.
*/
package com.example.cmsc335p2;

import com.example.cmsc335p2.shapes.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static javafx.scene.paint.Color.BLUE;

/**
 * Utility class for rendering shapes on a JavaFX Canvas
 */
public class ShapeRenderer {

    /**
     * Render a shape on the given graphics context
     *
     * @param gc      The graphics context to draw on
     * @param shape   The shape to render
     * @param centerX The center X coordinate for drawing
     * @param centerY The center Y coordinate for drawing
     */
    public static void renderShape(GraphicsContext gc, Shape shape, double centerX, double centerY) {
        // Set the color
        Color color = BLUE;
        gc.setFill(color);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);

        // 1.0 is 1:1 ratio pixel to unit
        double scale = 1.0;

        if (shape instanceof Circle) {
            renderCircle(gc, (Circle) shape, centerX, centerY, scale);
        } else if (shape instanceof Square) {
            renderSquare(gc, (Square) shape, centerX, centerY, scale);
        } else if (shape instanceof Triangle) {
            renderTriangle(gc, (Triangle) shape, centerX, centerY, scale);
        } else if (shape instanceof Rectangle) {
            renderRectangle(gc, (Rectangle) shape, centerX, centerY, scale);
        } else if (shape instanceof Sphere) {
            renderSphere(gc, (Sphere) shape, centerX, centerY, scale);
        } else if (shape instanceof Cube) {
            renderCube(gc, (Cube) shape, centerX, centerY, scale);
        } else if (shape instanceof Cone) {
            renderCone(gc, (Cone) shape, centerX, centerY, scale);
        } else if (shape instanceof Cylinder) {
            renderCylinder(gc, (Cylinder) shape, centerX, centerY, scale);
        } else if (shape instanceof Torus) {
            renderTorus(gc, (Torus) shape, centerX, centerY, scale);
        }
    }

    private static void renderCircle(GraphicsContext gc, Circle circle, double centerX, double centerY, double scale) {
        double radius = circle.getRadius() * scale;
        gc.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
        gc.strokeOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
    }

    private static void renderSquare(GraphicsContext gc, Square square, double centerX, double centerY, double scale) {
        double side = square.getSide() * scale;
        gc.fillRect(centerX - side / 2, centerY - side / 2, side, side);
        gc.strokeRect(centerX - side / 2, centerY - side / 2, side, side);
    }

    private static void renderTriangle(GraphicsContext gc, Triangle triangle, double centerX, double centerY, double scale) {
        double base = triangle.getBase() * scale;
        double height = triangle.getHeight() * scale;

        double[] xPoints = {centerX, centerX - base / 2, centerX + base / 2};
        double[] yPoints = {centerY - height / 2, centerY + height / 2, centerY + height / 2};

        gc.fillPolygon(xPoints, yPoints, 3);
        gc.strokePolygon(xPoints, yPoints, 3);
    }

    private static void renderRectangle(GraphicsContext gc, Rectangle rectangle, double centerX, double centerY, double scale) {
        double width = rectangle.getWidth() * scale;
        double height = rectangle.getHeight() * scale;
        gc.fillRect(centerX - width / 2, centerY - height / 2, width, height);
        gc.strokeRect(centerX - width / 2, centerY - height / 2, width, height);
    }

    private static void renderSphere(GraphicsContext gc, Sphere sphere, double centerX, double centerY, double scale) {
        renderImageShape(gc, "sphere.png", sphere.getRadius() * 2 * scale, centerX, centerY);
    }

    private static void renderCube(GraphicsContext gc, Cube cube, double centerX, double centerY, double scale) {
        renderImageShape(gc, "cube.png", cube.getSide() * scale, centerX, centerY);
    }

    private static void renderCone(GraphicsContext gc, Cone cone, double centerX, double centerY, double scale) {
        double size = Math.max(cone.getRadius() * 2, cone.getHeight()) * scale;
        renderImageShape(gc, "cone.png", size, centerX, centerY);
    }

    private static void renderCylinder(GraphicsContext gc, Cylinder cylinder, double centerX, double centerY, double scale) {
        double size = Math.max(cylinder.getRadius() * 2, cylinder.getHeight()) * scale;
        renderImageShape(gc, "cylinder.png", size, centerX, centerY);
    }

    private static void renderTorus(GraphicsContext gc, Torus torus, double centerX, double centerY, double scale) {
        double size = (torus.getMajorRadius() + torus.getMinorRadius()) * 2 * scale;
        renderImageShape(gc, "torus.png", size, centerX, centerY);
    }

    private static void renderImageShape(GraphicsContext gc, String imageName, double size, double centerX, double centerY) {
        try {
            Image image = new Image(ShapeRenderer.class.getResourceAsStream("/com/example/cmsc335p2/images/" + imageName));
            gc.drawImage(image, centerX - size/2, centerY - size/2, size, size);
        } catch (Exception e) {
            System.out.println("Image not found: " + imageName);
        }
    }


}