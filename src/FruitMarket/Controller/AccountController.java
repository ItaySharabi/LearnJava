package FruitMarket.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AccountController {
// Create a class for your FXML file.
// Change FruitMarket.views/account_page.fxml so it now has fx:controller="FruitMarket.Controller.AccountPage"

    @FXML
    private Button moveToMarketButton;

    @FXML
    private void backToMarket(MouseEvent mouseEvent) {
        System.out.println("Move back to market --->");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/FruitMarket/views/market.fxml"));

        try {
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) moveToMarketButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setData(String data) {

        System.out.println("Welcome to Account page:\n" +
                "Data from MarketController: " + data);
    }
}
