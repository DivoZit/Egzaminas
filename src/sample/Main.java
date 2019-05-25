package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    Database database = new Database();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Vartotojo kurimas");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setPadding(new Insets(35, 35, 35, 35));

        Text scenetitle = new Text("Pridėkit naują vartotoją");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("Vardas:");
        grid.add(userName, 0, 1);
        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label surname = new Label("Pavarde:");
        grid.add(surname, 0, 2);
        TextField surnameTextField = new TextField();
        grid.add(surnameTextField, 1, 2);


        Label adress = new Label("Adresas:");
        grid.add(adress, 0, 3);
        TextField adressTextField = new TextField();
        grid.add(adressTextField, 1, 3);

        Label email = new Label("El. Pastas:");
        grid.add(email, 0, 4);
        TextField emailTextField = new TextField();
        grid.add(emailTextField, 1, 4);

        Button btn = new Button("Prideti");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 5);
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 7);
        btn.setOnAction(e -> {
            String vardas = userTextField.getText();
            String pavarde = surnameTextField.getText();
            String adresas = adressTextField.getText();
            String elpastas = emailTextField.getText();

            database.createUser(vardas, pavarde, adresas, elpastas);

            System.out.println("Vardas: " + vardas);
            System.out.println("Pavarde: " + pavarde);
            System.out.println("Adresas: " + adresas);
            System.out.println("El. Pastas: " + elpastas);
            actiontarget.setFill(Color.BLACK);
            actiontarget.setText("Vartotojas sukurtas");
        });

        Button btnSearch = new Button("Ieškoti");
        HBox hbBtnSearch = new HBox(10);
        hbBtnSearch.setAlignment(Pos.BOTTOM_LEFT);
        hbBtnSearch.getChildren().add(btnSearch);
        grid.add(hbBtnSearch, 1, 6);
        final Text actiontargetSearch = new Text();
        grid.add(actiontargetSearch, 1, 7);
        btnSearch.setOnAction(e -> {
            String vardas = userTextField.getText();
            String pavarde = surnameTextField.getText();
            String adresas = adressTextField.getText();
            String elpastas = emailTextField.getText();

            database.selectUsers(vardas, pavarde, adresas, elpastas);

            System.out.println("Vardas: " + vardas);
            System.out.println("Pavarde: " + pavarde);
            System.out.println("Adresas: " + adresas);
            System.out.println("El. Pastas: " + elpastas);
            actiontarget.setFill(Color.BLACK);
            actiontarget.setText("Paieska įvygdyta");
        });


        Scene scene = new Scene(grid, 350, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
