import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.animation.KeyFrame;
import javafx.scene.text.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.animation.Timeline;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Stopwatch extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	BorderPane pane = new BorderPane();
	HBox hBox = new HBox();
	Text text = new Text("");
	String s = "";
	int t = 0;
	int c = 0;
	boolean d = true;
	boolean n = true;
	TextField tf = new TextField();
	Media media = new Media("https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3");
	MediaPlayer mediaPlayer = new MediaPlayer(media);
	
	public void start(Stage primaryStage) {
		EventHandler<ActionEvent> eventHandler = e ->{
			if(t > 0) {
				t = t -1;
				s = t + "";
				tf.setText(t + "");
				text.setText(s);
				text.setFont(Font.font("Times New Roman", 50));
				text.setTranslateX(70);
				text.setTranslateY(-30);
			}
			else {
				mediaPlayer.play();
			}
		};
		tf.setAlignment(Pos.BOTTOM_RIGHT);
		pane.setTop(tf);
		tf.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				if(!tf.getText().matches("[\\d]{0,}")) {
					tf.setText("Numbers only!");
				} else {
					tf.setEditable(false);
					int timer = Integer.parseInt(tf.getText());
					t = timer;
					
					Timeline time = new Timeline (new KeyFrame(Duration.seconds(1), eventHandler));
					time.setCycleCount(Timeline.INDEFINITE);
					time.play();
				}
			}
		});
	hBox.getChildren().add(text);
	pane.setBottom(hBox);
	Scene scene = new Scene(pane, 170, 120);
	primaryStage.setTitle("Stopwatch");
	primaryStage.setScene(scene);		
	primaryStage.show();	
	}	
}