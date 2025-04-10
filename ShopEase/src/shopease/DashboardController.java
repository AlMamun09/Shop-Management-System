/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package shopease;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class DashboardController implements Initializable {

    private double ricetPrice, oniontPrice, oiltPrice, flourtPrice, sugartPrice, lentilstPrice, mojotPrice, pranuptPrice, icetPrice;
    @FXML
    private Button btnProduct;
    @FXML
    private AnchorPane anchorProduct;
    @FXML
    private Label rice;
    @FXML
    private Label ricePrice;
    @FXML
    private Spinner<Integer> riceSpinner;
    int riceV;
    @FXML
    private Button riceAddbtn;
    @FXML
    private Spinner<Integer> oilSpinner;
    int oilV;
    @FXML
    private Button oilAddbtn;
    @FXML
    private Spinner<Integer> flourSpinner;
    int flourV;
    @FXML
    private Button flourAddbtn;
    @FXML
    private Spinner<Integer> onionSpinner;
    int onionV;
    @FXML
    private Button onionAddbtn;
    @FXML
    private Spinner<Integer> sugarSpinner;
    int sugarV;
    @FXML
    private Button sugarAddbtn;
    @FXML
    private Spinner<Integer> lentilsSpinner;
    int lentilsV;
    @FXML
    private Button lentilsAddbtn;
    @FXML
    private Spinner<Integer> mojoSpinner;
    int mojoV;
    @FXML
    private Button mojoAddbtn;
    @FXML
    private Spinner<Integer> pranupSpinner;
    int pranupV;
    @FXML
    private Button pranupAddbtn;
    @FXML
    private Spinner<Integer> iceSpinner;
    int iceV;
    @FXML
    private Button iceAddbtn;
    @FXML
    private AnchorPane calculationAnchorpane;
    @FXML
    private TableView<Memotable> memoTable;
    @FXML
    private TableColumn<Memotable, String> product;
    @FXML
    private TableColumn<Memotable, Integer> quantity;
    @FXML
    private TableColumn<Memotable, Double> price;

    @FXML
    private Label total;
    @FXML
    private TextField amount;
    @FXML
    private Label change;
    @FXML
    private Button btnRemove;
    @FXML
    private Button btnReceipt;
    @FXML
    private Button btnPay;
    @FXML
    private Button logoutbutton;

    /**
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Set up the value factory for riceSpinner
        SpinnerValueFactory<Integer> riceValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
        riceValueFactory.setValue(0);
        riceSpinner.setValueFactory(riceValueFactory);
        riceV = riceSpinner.getValue();

        // Set up the value factory for oilSpinner
        SpinnerValueFactory<Integer> oilValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
        oilValueFactory.setValue(0);
        oilSpinner.setValueFactory(oilValueFactory);
        oilV = oilSpinner.getValue();

        // Set up the value factory for flourSpinner
        SpinnerValueFactory<Integer> flourValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
        flourValueFactory.setValue(0);
        flourSpinner.setValueFactory(flourValueFactory);
        flourV = flourSpinner.getValue();

        // Set up the value factory for onionSpinner
        SpinnerValueFactory<Integer> onionValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
        onionValueFactory.setValue(0);
        onionSpinner.setValueFactory(onionValueFactory);
        onionV = onionSpinner.getValue();

        // Set up the value factory for sugarSpinner
        SpinnerValueFactory<Integer> sugarValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
        sugarValueFactory.setValue(0);
        sugarSpinner.setValueFactory(sugarValueFactory);
        sugarV = sugarSpinner.getValue();

        // Set up the value factory for lentilsSpinner
        SpinnerValueFactory<Integer> lentilsValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
        lentilsValueFactory.setValue(0);
        lentilsSpinner.setValueFactory(lentilsValueFactory);
        lentilsV = lentilsSpinner.getValue();

        // Set up the value factory for mojoSpinner
        SpinnerValueFactory<Integer> mojoValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
        mojoValueFactory.setValue(0);
        mojoSpinner.setValueFactory(mojoValueFactory);
        mojoV = mojoSpinner.getValue();

        // Set up the value factory for prunupSpinner
        SpinnerValueFactory<Integer> pranupValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
        pranupValueFactory.setValue(0);
        pranupSpinner.setValueFactory(pranupValueFactory);
        pranupV = pranupSpinner.getValue();

        // Set up the value factory for iceSpinner
        SpinnerValueFactory<Integer> iceValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
        iceValueFactory.setValue(0);
        iceSpinner.setValueFactory(iceValueFactory);
        iceV = iceSpinner.getValue();

        product.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().name));
        quantity.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().quantity).asObject());
        price.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
    }

    private final ObservableList<Memotable> data = FXCollections.observableArrayList();

    private void calculateTotal() {
        double totalPrice = 0.0;
        for (Memotable item : data) {
            totalPrice += item.getPrice();
        }
        total.setText(String.format("%.2f", totalPrice)); // Format total to two decimal places
    }

    @FXML
    void riceAddbtnAction(ActionEvent event) {
        ricetPrice = riceSpinner.getValue() * 0.7;
        ricetPrice = Double.parseDouble(String.format("%.2f", ricetPrice));
        Memotable rice = new Memotable("Rice", riceSpinner.getValue(), ricetPrice);
        data.add(rice);
        setTableItems();
        calculateTotal();
    }

    @FXML
    private void onionAddbtnAction(ActionEvent event) {
        double oniontPrice = onionSpinner.getValue() * 0.9;
        oniontPrice = Double.parseDouble(String.format("%.2f", oniontPrice));
        Memotable onion = new Memotable("Onion", onionSpinner.getValue(), oniontPrice);
        data.add(onion);
        setTableItems();
        calculateTotal();
    }

    @FXML
    private void sugarAddbtnAction(ActionEvent event) {
        double sugartPrice = sugarSpinner.getValue() * 0.7;
        sugartPrice = Double.parseDouble(String.format("%.2f", sugartPrice));
        Memotable sugar = new Memotable("Sugar", sugarSpinner.getValue(), sugartPrice);
        data.add(sugar);
        setTableItems();
        calculateTotal();
    }

    @FXML
    private void oilAddbtnAction(ActionEvent event) {
        oiltPrice = oilSpinner.getValue() * 1.7;
        oiltPrice = Double.parseDouble(String.format("%.2f", oiltPrice));
        Memotable Oil = new Memotable("Oil", oilSpinner.getValue(), oiltPrice);
        data.add(Oil);
        setTableItems();
        calculateTotal();
    }

    @FXML
    private void flourAddbtnAction(ActionEvent event) {
        double flourtPrice = flourSpinner.getValue() * 0.4;
        flourtPrice = Double.parseDouble(String.format("%.2f", flourtPrice));
        Memotable flour = new Memotable("Flour", flourSpinner.getValue(), flourtPrice);
        data.add(flour);
        setTableItems();
        calculateTotal();
    }

    @FXML
    private void lentilsAddbtnAction(ActionEvent event) {
        double lentilstPrice = lentilsSpinner.getValue() * 1.4;
        lentilstPrice = Double.parseDouble(String.format("%.2f", lentilstPrice));
        Memotable lentils = new Memotable("Lentils", lentilsSpinner.getValue(), lentilstPrice);
        data.add(lentils);
        setTableItems();
        calculateTotal();
    }

    @FXML
    private void mojoAddbtnAction(ActionEvent event) {
        double mojotPrice = mojoSpinner.getValue() * 0.25;
        mojotPrice = Double.parseDouble(String.format("%.2f", mojotPrice));
        Memotable mojo = new Memotable("Mojo", mojoSpinner.getValue(), mojotPrice);
        data.add(mojo);
        setTableItems();
        calculateTotal();
    }

    @FXML
    private void pranupAddbtnAction(ActionEvent event) {
        double pranuptPrice = pranupSpinner.getValue() * 0.9;
        pranuptPrice = Double.parseDouble(String.format("%.2f", pranuptPrice));
        Memotable pranup = new Memotable("PranUp", pranupSpinner.getValue(), pranuptPrice);
        data.add(pranup);
        setTableItems();
        calculateTotal();
    }

    @FXML
    private void iceAddbtnAction(ActionEvent event) {
        double icetPrice = iceSpinner.getValue() * 0.25;
        icetPrice = Double.parseDouble(String.format("%.2f", icetPrice));
        Memotable ice = new Memotable("Ice Cream", iceSpinner.getValue(), icetPrice);
        data.add(ice);
        setTableItems();
        calculateTotal();
    }

    @FXML
    private void amountAction(ActionEvent event) {
        // Assuming the amount entered by the user is related to the total amount to be paid

        // 1. Retrieve the amount entered by the user from the TextField or any other input field
        String enteredAmountText = amount.getText();

        // 2. Parse the entered amount to a double value
        double enteredAmount = Double.parseDouble(enteredAmountText);

        // 3. Calculate the change (if applicable) by subtracting the entered amount from the total amount
        double totalAmount = Double.parseDouble(total.getText()); // Assuming total is the Label showing the total amount
        double changeAmount = enteredAmount - totalAmount;

        // 4. Update the change Label with the calculated change
        change.setText(String.format("%.2f", changeAmount));
    }

    @FXML
    private void btnRemoveAction(ActionEvent event) {
        // Remove selected row from data
        Memotable selectedItem = memoTable.getSelectionModel().getSelectedItem();
        data.remove(selectedItem);
        // Recalculate total after removing row
        calculateTotal();
    }

    private String generateReceiptContent(double givenAmount, double changeAmount) {
        StringBuilder receiptContent = new StringBuilder();
        receiptContent.append("Receipt\n\n");

        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        receiptContent.append("Date: ").append(now.format(formatter)).append("\n\n");

        // Add purchased items, quantities, and prices
        receiptContent.append(String.format("%-20s %-10s %-10s\n", "Item", "Quantity", "Price"));
        receiptContent.append("----------------------------------------\n");
        for (Memotable item : data) {
            receiptContent.append(String.format("%-20s %-10d Taka%-10.2f\n", item.getName(), item.getQuantity(), item.getPrice()));
        }
        receiptContent.append("\n");

        // Calculate and add total amount
        double totalPrice = 0.0;
        for (Memotable item : data) {
            totalPrice += item.getPrice();
        }
        receiptContent.append(String.format("%-31s Taka%-10.2f\n", "Total", totalPrice));
        receiptContent.append(String.format("%-31s Taka%-10.2f\n", "Given Amount", givenAmount));
        receiptContent.append(String.format("%-31s Taka%-10.2f\n", "Change Amount", changeAmount));

        return receiptContent.toString();
    }

    @FXML
    private void btnReceiptAction(ActionEvent event) {
        // Calculate total amount
        double totalAmount = 0.0;
        for (Memotable item : data) {
            totalAmount += item.getPrice();
        }

        // Parse the entered amount from the TextField
        double enteredAmount = Double.parseDouble(amount.getText());

        // Calculate change amount
        double changeAmount = enteredAmount - totalAmount;

        // Generate receipt content
        String receiptContent = generateReceiptContent(enteredAmount, changeAmount);

        // Define the file name for the receipt
        String fileName = "receipt_" + getCurrentDateTime() + ".txt";

        // Write the receipt content to a file
        File file = new File(fileName);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(receiptContent);
        } catch (IOException e) {
            // Handle the IOException
            return;
        }

        // Open the file with the default application
        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            // Handle the IOException

        }
    }

// Method to get current date and time for file name
    private String getCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        return now.format(formatter);
    }

    @FXML
    private void btnPayAction(ActionEvent event) {
        // Create an alert dialog
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Thank You");
        alert.setHeaderText(null);
        alert.setContentText("Thank you for shopping with us!");

        // Show the alert dialog and wait for user response
        alert.showAndWait().ifPresent((ButtonType response) -> {
            // If user clicks OK, reset table and spinner values
            if (response == ButtonType.OK) {
                // Clear the table data
                data.clear();
                riceSpinner.getValueFactory().setValue(0);
                oilSpinner.getValueFactory().setValue(0);
                flourSpinner.getValueFactory().setValue(0);
                onionSpinner.getValueFactory().setValue(0);
                sugarSpinner.getValueFactory().setValue(0);
                lentilsSpinner.getValueFactory().setValue(0);
                mojoSpinner.getValueFactory().setValue(0);
                pranupSpinner.getValueFactory().setValue(0);
                iceSpinner.getValueFactory().setValue(0);
                total.setText("0.00");
                amount.clear();
                change.setText("0.00");
            }
        });
    }

    private void setTableItems() {
        memoTable.setItems(data);
    }

    @FXML
    private void signoutButton(ActionEvent event) {
        System.out.println("Signout button clicked"); // Debugging statement

        // Create an alert dialog
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sign Out");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to sign out?");

        // Show the alert dialog and wait for user response
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                System.out.println("User confirmed sign out"); // Debugging statement

                // User chose to sign out, load the Login.fxml page
                try {
                    // Load the login page
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
                    Parent root = loader.load();

                    System.out.println("Loaded Login.fxml successfully"); // Debugging statement

                    // Get the current stage and set the new scene
                    Stage stage = (Stage) logoutbutton.getScene().getWindow();
                    stage.setScene(new Scene(root));
                    stage.setTitle("Login");

                    // Show the new stage
                    stage.show();
                } catch (IOException e) {
                    System.err.println("Error loading Login.fxml: " + e.getMessage());
                }
            }
        });
    }

    private class Memotable {

        String name;
        int quantity;
        private final SimpleDoubleProperty price; // Change this to a property

        public Memotable(String name, int quantity, double price) {
            this.name = name;
            this.quantity = quantity;
            this.price = new SimpleDoubleProperty(price);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getPrice() {
            return price.get(); // Use get() method to retrieve the property value
        }

        public void setPrice(double price) {
            this.price.set(price); // Use set() method to update the property value
        }

        public SimpleDoubleProperty priceProperty() {
            return price; // Getter for the property itself
        }
    }

}
