package FruitMarket.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import FruitMarket.main.Main;
import FruitMarket.main.MyListener;
import FruitMarket.model.Fruit;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class MarketController implements Initializable {

    @FXML
    private TextField searchText;

    @FXML
    private Button btnSearch;

    @FXML
    private VBox chosenFruitCard;

    @FXML
    private ImageView accountImage;

    @FXML
    private Label fruitNameLabel;

    @FXML
    private Label fruitPriceLabel;

    @FXML
    private ImageView fruitImg;

    @FXML
    private ScrollPane scroll;

    @FXML
    private GridPane grid;

    private List<Fruit> fruits = new ArrayList<>();
    private Image image;
    private MyListener myListener;

    private List<Fruit> getData() {
        List<Fruit> fruits = new ArrayList<>();
        Fruit fruit;

        fruit = new Fruit();
        fruit.setName("Kiwi");
        fruit.setPrice(2.99);
        fruit.setImgSrc("/FruitMarket/img/kiwi.png");
        fruit.setColor("6A7324");
        fruits.add(fruit);

        fruit = new Fruit();
        fruit.setName("Shnitzel");
        fruit.setPrice(50001239);
        fruit.setImgSrc("/FruitMarket/img/kiwi.png");
        fruit.setColor("6A7324");
        fruits.add(fruit);

        fruit = new Fruit();
        fruit.setName("Coconut");
        fruit.setPrice(3.99);
        fruit.setImgSrc("/FruitMarket/img/coconut.png");
        fruit.setColor("A7745B");
        fruits.add(fruit);

        fruit = new Fruit();
        fruit.setName("Peach");
        fruit.setPrice(1.50);
        fruit.setImgSrc("/FruitMarket/img/peach.png");
        fruit.setColor("F16C31");
        fruits.add(fruit);

        fruit = new Fruit();
        fruit.setName("Grapes");
        fruit.setPrice(0.99);
        fruit.setImgSrc("/FruitMarket/img/grapes.png");
        fruit.setColor("291D36");
        fruits.add(fruit);

        fruit = new Fruit();
        fruit.setName("Watermelon");
        fruit.setPrice(4.99);
        fruit.setImgSrc("/FruitMarket/img/watermelon.png");
        fruit.setColor("22371D");
        fruits.add(fruit);

        fruit = new Fruit();
        fruit.setName("Orange");
        fruit.setPrice(2.99);
        fruit.setImgSrc("/FruitMarket/img/orange.png");
        fruit.setColor("FB5D03");
        fruits.add(fruit);

        fruit = new Fruit();
        fruit.setName("StrawBerry");
        fruit.setPrice(0.99);
        fruit.setImgSrc("/FruitMarket/img/strawberry.png");
        fruit.setColor("80080C");
        fruits.add(fruit);

        fruit = new Fruit();
        fruit.setName("Mango");
        fruit.setPrice(0.99);
        fruit.setImgSrc("/FruitMarket/img/mango.png");
        fruit.setColor("FFB605");
        fruits.add(fruit);

        fruit = new Fruit();
        fruit.setName("Cherry");
        fruit.setPrice(0.99);
        fruit.setImgSrc("/FruitMarket/img/cherry.png");
        fruit.setColor("5F060E");
        fruits.add(fruit);

        fruit = new Fruit();
        fruit.setName("Banana");
        fruit.setPrice(1.99);
        fruit.setImgSrc("/FruitMarket/img/banana.png");
        fruit.setColor("E7C00F");
        fruits.add(fruit);

        return fruits;
    }

    private void setChosenFruit(Fruit fruit) {
        fruitNameLabel.setText(fruit.getName());
        fruitPriceLabel.setText(Main.CURRENCY + fruit.getPrice());
        image = new Image(getClass().getResourceAsStream(fruit.getImgSrc()));
        fruitImg.setImage(image);
        chosenFruitCard.setStyle("-fx-background-color: #" + fruit.getColor() + ";\n" +
                "    -fx-background-radius: 30;");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fruits.addAll(getData());
        setupItems();
    }

    private void setupItems() {
        if (fruits.size() > 0) {
            setChosenFruit(fruits.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(Fruit fruit) {
                    setChosenFruit(fruit);
                }
            };
        }

        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < fruits.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/FruitMarket/views/item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(fruits.get(i), myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void search(ActionEvent event) {
        System.out.println("searching...");

        grid = new GridPane();
        fruits = new ArrayList<>();
        List<Fruit> data = getData();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getName().toLowerCase().contains(searchText.getText().toLowerCase())) {
                fruits.add(data.get(i));
            }
        }
        // Same solution as th for loop in line 218:
//        fruits = getData()
//                .stream()
//                .filter(x -> x.getName().contains(searchText.getText()))
//                .collect(Collectors.toList());
        scroll.setContent(grid);
        setupItems();
    }

    @FXML
    void onKeyTyped(KeyEvent event) {
        if (searchText.getText().isEmpty()) {
            grid = new GridPane();
            scroll.setContent(grid);
            fruits = new ArrayList<>(getData());
            setupItems();
        }
    }

    @FXML
    public void accountImageClicked() {
        System.out.println(" ---- Account button clicked! ---- ");

        FXMLLoader fxmlLoader = new FXMLLoader(); //Create an FXML loader object
        // Set it's loading location to the specified:
        fxmlLoader.setLocation(getClass().getResource("/FruitMarket/views/account_page.fxml"));

        try {
            Parent root = fxmlLoader.load(); // Load the FXML file onto an object
            AccountController accountController = fxmlLoader.getController(); // Get the controller class

            accountController.setData("Itay Sharabi"); // Send data to the controller class
            // Get an instance of the current stage using some view on the screen (Our clicked button):
            Stage stage = (Stage) accountImage.getScene().getWindow();
            // Create the new Scene that will be launched:
            Scene scene = new Scene(root, stage.getWidth(), stage.getHeight());
            stage.setScene(scene); // Launch Scene!

        } catch (Exception e) {
            // If failed to launch scene - this code will be executed
            e.printStackTrace();
        }
    }
}
