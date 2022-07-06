import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ControlCircle extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override //Override the start method in the Application
	public void start(Stage primaryStage) {
		//Hold four buttons in an HBox
		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.CENTER);
		Button btLeft = new Button(" Left ");
		Button btRight = new Button(" Right ");
		Button btUp = new Button(" Up ");
		Button btDown = new Button(" Down ");
		hBox.getChildren().add(btLeft);
		hBox.getChildren().add(btRight);
		hBox.getChildren().add(btUp);
		hBox.getChildren().add(btDown);
		
		Circle circle = new Circle(50);
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.WHITE);
		circle.setCenterX(150);
		circle.setCenterY(150);
		
		//Create and register the handlers
		btLeft.setOnMouseClicked(e -> {
			circle.setCenterX(circle.getCenterX() - 10);
			if (circle.getCenterX() < 50) {
				circle.setCenterX(circle.getCenterX() + 10);
				System.out.println("Out of Bounds.");
			}
		});
		btRight.setOnMouseClicked(e -> {
			circle.setCenterX(circle.getCenterX() + 10);
			if (circle.getCenterX() > 250) {
				circle.setCenterX(circle.getCenterX() - 10);
				System.out.println("Out of Bounds.");
			}
		});
		btUp.setOnMouseClicked(e -> {
			circle.setCenterY(circle.getCenterY() - 10);
			if (circle.getCenterY() < 50) {
				circle.setCenterY(circle.getCenterY() + 10);
				System.out.println("Out of Bounds.");
			}
		});
		btDown.setOnMouseClicked(e -> {
			circle.setCenterY(circle.getCenterY() + 10);
			if (circle.getCenterY() > 250) {
				circle.setCenterY(circle.getCenterY() - 10);
				System.out.println("Out of Bounds.");
			}
		});
		
		BorderPane borderPane = new BorderPane();
		borderPane.getChildren().add(circle);
		borderPane.setBottom(hBox);
		BorderPane.setAlignment(hBox, Pos.CENTER);
		
		//Create a scene and place it in the stage
		Scene scene = new Scene(borderPane, 300, 300);
		primaryStage.setTitle("Moving Circle"); //Set the stage title
		primaryStage.setScene(scene); //Place the scene in the stage
		primaryStage.show(); //Display the stage
	}
}