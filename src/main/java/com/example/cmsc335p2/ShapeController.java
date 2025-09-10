/**
 * FileName: ShapeController.java
 * Date: September 7, 2025
 * Author: Spencer Renfro
 * Purpose: Controller for the shape-view.fxml file. Handles user interaction with the GUI.
 */

package com.example.cmsc335p2;

import com.example.cmsc335p2.shapes.Shape;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for the Shape Selector GUI
 */
public class ShapeController implements Initializable {

    public Button clearButton;
    @FXML private ComboBox<String> shapeComboBox;
    @FXML private Label dimension1Label;
    @FXML private Label dimension2Label;
    @FXML private TextField dimension1Field;
    @FXML private TextField dimension2Field;
    @FXML private Canvas shapeCanvas;


    private Shape currentShape;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Set up shape selection handler
        shapeComboBox.setOnAction(e -> updateDimensionFields());

        // Hide dimension fields initially
        dimension1Label.setVisible(false);
        dimension1Field.setVisible(false);
        dimension2Label.setVisible(false);
        dimension2Field.setVisible(false);

        clearCanvas();
    }

    /**
     * Update dimension input fields based on selected shape
     */
    private void updateDimensionFields() {
        String selectedShape = shapeComboBox.getValue();
        if (selectedShape == null) return;

        String[] labels = ShapeFactory.getDimensionLabels(selectedShape);
        int requiredDimensions = ShapeFactory.getRequiredDimensions(selectedShape);

        if (requiredDimensions >= 1) {
            dimension1Label.setText(labels[0] + ":");
            dimension1Label.setVisible(true);
            dimension1Field.setVisible(true);
        }

        if (requiredDimensions >= 2) {
            dimension2Label.setText(labels[1] + ":");
            dimension2Label.setVisible(true);
            dimension2Field.setVisible(true);
        } else {
            dimension2Label.setVisible(false);
            dimension2Field.setVisible(false);
        }

        // Clear fields when switching shapes
        if(!dimension1Field.visibleProperty().get() && !dimension2Field.visibleProperty().get()) {
            dimension1Field.clear();
            dimension2Field.clear();
        }
        clearCanvas();
    }



    /**
     * Handle create shape button click
     */
    @FXML
    private void onCreateShapeClick() {
        String shapeType = shapeComboBox.getValue();
        if (shapeType == null) {
            return;
        }

        double[] dimensions = getDimensions(shapeType);
        if (dimensions == null) return; // Invalid input

        currentShape = ShapeFactory.createShape(shapeType, dimensions);
        renderShape();
    }

    /**
     * Get dimensions from input fields
     */
    private double[] getDimensions(String shapeType) {
        int requiredDimensions = ShapeFactory.getRequiredDimensions(shapeType);
        double[] dimensions = new double[requiredDimensions];

        // First dimension
        String dim1Text = dimension1Field.getText().trim();
        if (dim1Text.isEmpty()) {
            return null;
        }
        dimensions[0] = Double.parseDouble(dim1Text);
        if (dimensions[0] <= 0) {
            return null;
        }

        // Second dimension if needed
        if (requiredDimensions >= 2) {
            String dim2Text = dimension2Field.getText().trim();
            if (dim2Text.isEmpty()) {
                return null;
            }
            dimensions[1] = Double.parseDouble(dim2Text);
            if (dimensions[1] <= 0) {
                return null;
            }
        }
        return dimensions;
    }


    /**
     * Render the shape on the canvas
     */
    private void renderShape() {
        if (currentShape == null) return;
        if (currentShape.getNumberOfDimensions() < 1) return;

        GraphicsContext gc = shapeCanvas.getGraphicsContext2D();
        clearCanvas();

        // Center the shape
        double canvasWidth = shapeCanvas.getWidth();
        double canvasHeight = shapeCanvas.getHeight();
        double centerX = canvasWidth / 2;
        double centerY = canvasHeight / 2;

        ShapeRenderer.renderShape(gc, currentShape, centerX, centerY);
    }

    /**
     * Clear the canvas
     */
    private void clearCanvas() {
        GraphicsContext gc = shapeCanvas.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, shapeCanvas.getWidth(), shapeCanvas.getHeight());
        gc.setStroke(Color.LIGHTGRAY);
        gc.strokeRect(0, 0, shapeCanvas.getWidth(), shapeCanvas.getHeight());
    }

    /**
     * Handle clear button click
     */

    @FXML
    public void onClearClick() {
        clearCanvas();
    }
}
