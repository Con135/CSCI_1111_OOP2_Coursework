import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class TargetPractice extends Application {
	private int order;
	double x;
	double y;
	int count;
	boolean shot;
	long startTime;
	long stopTime;
	double time;
	Pane pane = new Pane();
	
	@Override // Override the start method in the Application class
	
	public void start(Stage primaryStage) {
		TextField tfOrder = new TextField();
		Button btReady = new Button("Ready?");

		// Pane to hold label, text field and a button
		HBox hBoxQuestion = new HBox(10);
		HBox hBoxReady = new HBox(10);
		hBoxReady.setVisible(false);
		
		//Hbox for textfield
		hBoxQuestion.getChildren().addAll(new Label("Enter the number of targets: "), tfOrder);
		hBoxQuestion.setTranslateX(390);
		hBoxQuestion.setTranslateY(300);
		//Hbox for button
		hBoxReady.getChildren().add(btReady);
		hBoxReady.setTranslateX(470);
		hBoxReady.setTranslateY(330);
		
		tfOrder.setOnAction(
				e -> {order = Integer.parseInt(tfOrder.getText());
					hBoxReady.setVisible(true);
					setOrder(order);
				});
		
		btReady.setOnAction(
				e -> {tfOrder.setVisible(false);
					hBoxQuestion.setVisible(false);
					hBoxReady.setVisible(false);
					
					startTime = System.currentTimeMillis();
					
					setShot(false);
					
					shootingRange();
				});
		
		tfOrder.setPrefColumnCount(4);
		tfOrder.setAlignment(Pos.CENTER);
		btReady.setAlignment(Pos.CENTER);
		pane.getChildren().addAll(hBoxQuestion, hBoxReady);
		
		//Create a scene and place it in the stage
		Scene scene = new Scene(pane, 1000, 1000);
		primaryStage.setTitle("Target Practice");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void shootingRange() {
		if (getShot() == false) {
			if (count < getOrder()) {
				spawnTarget();
				count++;
			}
			else {
				finalTime();
			}
		}
	}
	
	public void spawnTarget() {
		x = (int)((Math.random() * 980) + 10);
		y = (int)((Math.random() * 695) + 10);
		RadioButton target = new RadioButton();
		target.setTranslateX(x);
		target.setTranslateY(y);
		pane.getChildren().add(target);
		setShot(true);
		
		target.setOnAction(
				e -> {;
					pane.getChildren().remove(target);
					setShot(false);
					shootingRange();
				});
	}
	
	public void finalTime() {
		stopTime = System.currentTimeMillis();
		time = (stopTime - startTime) / 1000.0;
		
		//Hbox for EndingTime
		HBox hBoxEndingTime = new HBox(10);
		hBoxEndingTime.getChildren().addAll(new Label("Congrats, your time is " + time + " seconds."));
		hBoxEndingTime.setTranslateX(390);
		hBoxEndingTime.setTranslateY(300);
		pane.getChildren().addAll(hBoxEndingTime);
	}
	
	public int getOrder() {
		return order;
	}
	
	public void setOrder(int order) {
		this.order = order;
	}
	
	public boolean getShot() {
		return shot;
	}
	
	public void setShot(boolean shot) {
		this.shot = shot;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}