/**
 * FileName: ShapeController.java
 * Date: September 7, 2025
 * Author: Spencer Renfro
 * Purpose: The controller for the shape-view.fxml file. This handles all user interaction with the GUI.
 */


package com.example.cmsc335p2;

import com.example.cmsc335p2.shapes.Shape;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
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
    @FXML private Button createShapeButton;
    @FXML private Canvas shapeCanvas;
    @FXML private TextArea shapeInfoArea;

    private Shape currentShape;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // updateDimensionFields() is called when a shape is selected
        shapeComboBox.setOnAction(e -> updateDimensionFields());

        // Initially hide dimension fields
        dimension2Label.setVisible(false);
        dimension2Field.setVisible(false);


        // Clear canvas
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

        // Clear previous values
        dimension1Field.clear();
        dimension2Field.clear();
        shapeInfoArea.clear();
        clearCanvas();
    }

    /**
     * Update existing shape dimensions from input fields (for real-time resizing)
     */
    private void updateShapeFromInput() {
        if (currentShape == null || currentShape.getNumberOfDimensions() != 2) {
            return;
        }

        try {
            String shapeType = shapeComboBox.getValue();
            if (shapeType == null) return;

            // Get current dimensions from input fields
            String dim1Text = dimension1Field.getText().trim();
            if (dim1Text.isEmpty()) return; // Don't update if field is empty

            double dimension1 = Double.parseDouble(dim1Text);
            if (dimension1 <= 0) return; // Don't update if invalid

            // Update the shape based on its type
            if (currentShape instanceof com.example.cmsc335p2.shapes.Circle) {
                ((com.example.cmsc335p2.shapes.Circle) currentShape).setRadius(dimension1);
            } else if (currentShape instanceof com.example.cmsc335p2.shapes.Square) {
                ((com.example.cmsc335p2.shapes.Square) currentShape).setSide(dimension1);
            } else if (currentShape instanceof com.example.cmsc335p2.shapes.Rectangle) {
                String dim2Text = dimension2Field.getText().trim();
                if (dim2Text.isEmpty()) return;
                double dimension2 = Double.parseDouble(dim2Text);
                if (dimension2 <= 0) return;

                com.example.cmsc335p2.shapes.Rectangle rect = (com.example.cmsc335p2.shapes.Rectangle) currentShape;
                rect.setWidth(dimension1);
                rect.setHeight(dimension2);
            } else if (currentShape instanceof com.example.cmsc335p2.shapes.Triangle) {
                String dim2Text = dimension2Field.getText().trim();
                if (dim2Text.isEmpty()) return;
                double dimension2 = Double.parseDouble(dim2Text);
                if (dimension2 <= 0) return;

                com.example.cmsc335p2.shapes.Triangle tri = (com.example.cmsc335p2.shapes.Triangle) currentShape;
                tri.setBase(dimension1);
                tri.setHeight(dimension2);
            }

            // Update display
            displayShapeInfo();
            renderShape();

        } catch (NumberFormatException e) {
            // Ignore invalid input during typing
        }
    }

    /**
     * Handle create shape button click
     */
    @FXML
    private void onCreateShapeClick() {
        try {
            String shapeType = shapeComboBox.getValue();


            if (shapeType == null) {
                showAlert("Please select a shape type.");
                return;
            }

            // Get dimensions
            double[] dimensions = getDimensions(shapeType);
            if (dimensions == null) return; // Error already shown

            // Create shape
            currentShape = ShapeFactory.createShape(shapeType, dimensions);

            // Display shape info
            displayShapeInfo();

            // Render shape
            renderShape();

        } catch (Exception e) {
            showAlert("Error creating shape: " + e.getMessage());
        }
    }

    /**
     * Get dimensions from input fields
     */
    private double[] getDimensions(String shapeType) {
        try {
            int requiredDimensions = ShapeFactory.getRequiredDimensions(shapeType);
            double[] dimensions = new double[requiredDimensions];

            // Get first dimension
            String dim1Text = dimension1Field.getText().trim();
            if (dim1Text.isEmpty()) {
                showAlert("Please enter " + ShapeFactory.getDimensionLabels(shapeType)[0]);
                return null;
            }
            dimensions[0] = Double.parseDouble(dim1Text);
            if (dimensions[0] <= 0) {
                showAlert("Dimensions must be positive numbers.");
                return null;
            }

            // Get second dimension if needed
            if (requiredDimensions >= 2) {
                String dim2Text = dimension2Field.getText().trim();
                if (dim2Text.isEmpty()) {
                    showAlert("Please enter " + ShapeFactory.getDimensionLabels(shapeType)[1]);
                    return null;
                }
                dimensions[1] = Double.parseDouble(dim2Text);
                if (dimensions[1] <= 0) {
                    showAlert("Dimensions must be positive numbers.");
                    return null;
                }
            }

            return dimensions;

        } catch (NumberFormatException e) {
            showAlert("Please enter valid numeric values for dimensions.");
            return null;
        }
    }

    /**
     * Display shape information in the text area
     */
    private void displayShapeInfo() {
        if (currentShape == null) return;

        StringBuilder info = new StringBuilder();
        info.append("Shape Information:\n");
        info.append("==================\n\n");
        info.append("Type: ").append(currentShape.getName()).append("\n");
        info.append("Color: ").append(currentShape.getColor()).append("\n");
        info.append("Dimensions: ").append(currentShape.getNumberOfDimensions()).append("D\n\n");

        if (currentShape.getNumberOfDimensions() == 2) {
            info.append("Area: ").append(String.format("%.2f", currentShape.calculateArea())).append(" square units\n");
        } else {
            info.append("Surface Area: ").append(String.format("%.2f", currentShape.calculateArea())).append(" square units\n");
            if (currentShape instanceof com.example.cmsc335p2.shapes.ThreeDimensionalShape) {
                com.example.cmsc335p2.shapes.ThreeDimensionalShape shape3D =
                    (com.example.cmsc335p2.shapes.ThreeDimensionalShape) currentShape;
                info.append("Volume: ").append(String.format("%.2f", shape3D.calculateVolume())).append(" cubic units\n");
            }
        }

        info.append("\nDetailed Information:\n");
        info.append(currentShape.toString());

        shapeInfoArea.setText(info.toString());
    }

    /**
     * Render the shape on the canvas
     */
    private void renderShape() {
        if (currentShape == null) return;

        GraphicsContext gc = shapeCanvas.getGraphicsContext2D();
        clearCanvas();

        // Calculate scale to fit shape nicely in canvas
        double canvasWidth = shapeCanvas.getWidth();
        double canvasHeight = shapeCanvas.getHeight();
        double centerX = canvasWidth / 2;
        double centerY = canvasHeight / 2;

        // Determine appropriate scale based on shape dimensions
        double scale = calculateScale();

        // Render the shape
        ShapeRenderer.renderShape(gc, currentShape, centerX, centerY);
    }

    /**
     * Calculate appropriate scale for rendering
     */
    private double calculateScale() {
        if (currentShape == null) return 1.0;

        double canvasSize = Math.min(shapeCanvas.getWidth(), shapeCanvas.getHeight()) * 0.6;

        // Get the largest dimension of the shape
        double maxDimension = 1.0;

        if (currentShape instanceof com.example.cmsc335p2.shapes.Circle) {
            maxDimension = ((com.example.cmsc335p2.shapes.Circle) currentShape).getRadius() * 2;
        } else if (currentShape instanceof com.example.cmsc335p2.shapes.Square) {
            maxDimension = ((com.example.cmsc335p2.shapes.Square) currentShape).getSide();
        } else if (currentShape instanceof com.example.cmsc335p2.shapes.Rectangle) {
            com.example.cmsc335p2.shapes.Rectangle rect = (com.example.cmsc335p2.shapes.Rectangle) currentShape;
            maxDimension = Math.max(rect.getWidth(), rect.getHeight());
        } else if (currentShape instanceof com.example.cmsc335p2.shapes.Triangle) {
            com.example.cmsc335p2.shapes.Triangle tri = (com.example.cmsc335p2.shapes.Triangle) currentShape;
            maxDimension = Math.max(tri.getBase(), tri.getHeight());
        } else if (currentShape instanceof com.example.cmsc335p2.shapes.Sphere) {
            maxDimension = ((com.example.cmsc335p2.shapes.Sphere) currentShape).getRadius() * 2;
        } else if (currentShape instanceof com.example.cmsc335p2.shapes.Cube) {
            maxDimension = ((com.example.cmsc335p2.shapes.Cube) currentShape).getSide();
        } else if (currentShape instanceof com.example.cmsc335p2.shapes.Cylinder) {
            com.example.cmsc335p2.shapes.Cylinder cyl = (com.example.cmsc335p2.shapes.Cylinder) currentShape;
            maxDimension = Math.max(cyl.getRadius() * 2, cyl.getHeight());
        } else if (currentShape instanceof com.example.cmsc335p2.shapes.Cone) {
            com.example.cmsc335p2.shapes.Cone cone = (com.example.cmsc335p2.shapes.Cone) currentShape;
            maxDimension = Math.max(cone.getRadius() * 2, cone.getHeight());
        } else if (currentShape instanceof com.example.cmsc335p2.shapes.Torus) {
            com.example.cmsc335p2.shapes.Torus torus = (com.example.cmsc335p2.shapes.Torus) currentShape;
            maxDimension = (torus.getMajorRadius() + torus.getMinorRadius()) * 2;
        }

        return canvasSize / maxDimension;
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
     * Show alert dialog
     */
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Input Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    public void onClearClick(ActionEvent actionEvent) {
        clearCanvas();
    }
}
