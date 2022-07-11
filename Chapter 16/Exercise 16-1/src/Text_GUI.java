import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;
import javafx.scene.paint.Color;

public class Text_GUI extends Application {

		public static void main(String[] args) {
			launch(args);
		}
		
		@Override //Override the start method in the Application
		public void start(Stage primaryStage) {
			BorderPane pane = new BorderPane();
			
			//Hold two buttons in an HBox
			HBox bottomHBox = new HBox();
			HBox topHBox = new HBox();
			bottomHBox.setSpacing(10);
			bottomHBox.setAlignment(Pos.CENTER);
			topHBox.setSpacing(10);
			topHBox.setAlignment(Pos.CENTER);
			Button btLeft = new Button(" <= ");
			Button btRight = new Button(" => ");
			RadioButton btRed = new RadioButton("Red");
			RadioButton btYellow = new RadioButton("Yellow");
			RadioButton btBlack = new RadioButton("Black");
			RadioButton btOrange = new RadioButton("Orange");
			RadioButton btGreen = new RadioButton("Green");
			
			//Setting the bottom hBox
			bottomHBox.getChildren().add(btLeft);
			bottomHBox.getChildren().add(btRight);
			pane.setBottom(bottomHBox);
			BorderPane.setAlignment(bottomHBox, Pos.CENTER);
			
			//Setting the top hBox
			topHBox.getChildren().add(btRed);
			topHBox.getChildren().add(btYellow);
			topHBox.getChildren().add(btBlack);
			topHBox.getChildren().add(btOrange);
			topHBox.getChildren().add(btGreen);
			pane.setTop(topHBox);
			BorderPane.setAlignment(topHBox, Pos.CENTER);
			
			//Create text
			Text text = new Text(150, 50, "Programming is fun");
			pane.getChildren().addAll(text);

						
			//Create and register the handlers
			btLeft.setOnMouseClicked(e -> {
				text.setX(text.getX() - 10);
				if (text.getX() < 0) {
					text.setX(text.getX() + 10);
					System.out.println("Out of Bounds.");
				}
			});
			btRight.setOnMouseClicked(e -> {
				text.setX(text.getX() + 10);
				if (text.getX() > 300) {
					text.setX(text.getX() - 10);
					System.out.println("Out of Bounds.");
				}
			});
			
			btRed.setOnAction(e -> {
				if (btRed.isSelected()) {
					text.setFill(Color.RED);
				}
			});
			btYellow.setOnAction(e -> {
				if (btYellow.isSelected()) {
					text.setFill(Color.YELLOW);
				}
			});
			btBlack.setOnAction(e -> {
				if (btBlack.isSelected()) {
					text.setFill(Color.BLACK);
				}
			});
			btOrange.setOnAction(e -> {
				if (btOrange.isSelected()) {
					text.setFill(Color.ORANGE);
				}
			});
			btGreen.setOnAction(e -> {
				if (btGreen.isSelected()) {
					text.setFill(Color.GREEN);
				}
			});

			//Create a scene and place it in the stage
			Scene scene = new Scene(pane, 405, 100);
			primaryStage.setTitle("Text GUI"); //Set the stage title
			primaryStage.setScene(scene); //Place the scene in the stage
			primaryStage.show(); //Display the stage
		}
}