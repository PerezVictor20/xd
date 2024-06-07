package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    private static final String[] nombres = {"Juan", "Maria", "Pedro", "Ana", "Luis", "Laura", "Carlos", "Sofia", "Miguel", "Lucia", "Diego", "Elena", "Javier", "Paula", "Alejandro"};
    private static final String[] apellidos = {"Gomez", "Rodriguez", "Perez", "Fernandez", "Lopez", "Martinez", "Gonzalez", "Sanchez", "Diaz", "Hernandez", "Moreno", "Jimenez", "Alvarez", "Ramos", "Ruiz"};

    @Override
    public void start(Stage primaryStage) {
        try {
            AnchorPane root = new AnchorPane();
            Scene scene = new Scene(root, 500, 500);

            // Crear un ListView vacío
            ListView<String> listView1 = new ListView<>();
            ObservableList<String> items1 = FXCollections.observableArrayList();
            listView1.setItems(items1);

            // Establecer el tamaño y la posición del ListView en el AnchorPane
            listView1.setPrefSize(240, 420);
            AnchorPane.setTopAnchor(listView1, 10.0); // Alineado con la parte superior
            AnchorPane.setRightAnchor(listView1, 10.0); // Alineado con la derecha

            // Crear un TextField
            TextField textField = new TextField();
            textField.setPrefSize(240, 30);
            AnchorPane.setTopAnchor(textField, 450.0); // Dejar espacio para el ListView
            AnchorPane.setRightAnchor(textField, 10.0); // Alineado con la derecha

            // Crear un ListView con 15 Labels y ImageView
            ListView<HBox> listView2 = new ListView<>();
            ObservableList<HBox> boxes = FXCollections.observableArrayList();
            Random random = new Random();
            for (int i = 1; i <= 15; i++) {
                String nombre = nombres[random.nextInt(nombres.length)];
                String apellido = apellidos[random.nextInt(apellidos.length)];
                Label label = new Label(nombre + " " + apellido);
                label.setStyle("-fx-padding: 5 0 5 0;"); // Agregar un pequeño espaciado vertical
                ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("arthur.jpg")));
                imageView.setFitHeight(20);
                imageView.setFitWidth(20);
                HBox hbox = new HBox(label, imageView);
                boxes.add(hbox);
            }
            listView2.setItems(boxes);

            // Crear un VBox para contener los HBox
            VBox vbox = new VBox();
            vbox.setSpacing(5); // Espacio entre los elementos del VBox
            vbox.getChildren().addAll(boxes);

            // Crear un ScrollPane para el segundo ListView y las HBox
            ScrollPane scrollPane = new ScrollPane();
            scrollPane.setContent(vbox);
            scrollPane.setPrefSize(220, 470); // Altura limitada para mostrar solo unos pocos nombres
            scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS); // Mostrar siempre la barra de desplazamiento vertical
            AnchorPane.setTopAnchor(scrollPane, 10.0); // Alineado con la parte superior
            AnchorPane.setLeftAnchor(scrollPane, 10.0); // Alineado con la izquierda
            scrollPane.setFitToWidth(true); // Ajustar al ancho

            // Agregar el ListView y el TextField al AnchorPane
            root.getChildren().addAll(listView1, textField, scrollPane);

            // Agregar hoja de estilos
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
} 
