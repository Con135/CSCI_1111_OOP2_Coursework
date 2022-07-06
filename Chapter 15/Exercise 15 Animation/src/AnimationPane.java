import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimationPane extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) {
		//Create a pane
		Pane pane = new Pane();
		
		//Create a rectangle
		Rectangle rectangle = new Rectangle(0, 0, 25, 50);
		rectangle.setFill(Color.RED);
		
		//Create a pentagon
		Polygon polygon = new Polygon();
		polygon.setRotate(22.5); 
		polygon.setFill(Color.WHITE);
		polygon.setStroke(Color.BLACK);
		ObservableList<Double> list = polygon.getPoints();
		
		final double pentagonWidth = 250, pentagonHeight = 250;
		double centerX = pentagonWidth / 2, centerY = pentagonHeight / 2;
		double radius = Math.min(pentagonWidth, pentagonHeight) * 0.4;

		int s = 8;
		for (int i = 0; i < s; i++) {
			list.add(centerX + radius * Math.cos(2 * i * Math.PI / s)); 
			list.add(centerY - radius * Math.sin(2 * i * Math.PI / s));
		}
		//Add polygon and rectangle to the pane
		pane.getChildren().add(polygon);
		pane.getChildren().add(rectangle);
		
		//Create a path transition
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(4000));
		pt.setPath(polygon);
		pt.setNode(rectangle);
		pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.play(); //Start animation
		
		//Apply a fade transition to rectangle
		FadeTransition ft = new FadeTransition(Duration.millis(3000), rectangle);
		ft.setFromValue(1.0);
		ft.setToValue(0.1);
		ft.setCycleCount(Timeline.INDEFINITE);
		ft.setAutoReverse(true);
		ft.play(); //Start animation
		
		polygon.setOnMousePressed(e -> {
			pt.pause();
			ft.pause();
		});
		polygon.setOnMouseReleased(e -> {
			pt.play();
			ft.play();
		});
			
		
		
		//Create a scene and place it in the stage
		Scene scene = new Scene(pane, 250, 250);
		primaryStage.setTitle("Path and Fade Transition Demo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}	
}