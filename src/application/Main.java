package application;
	
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {
	
	private double height = 1000;
	private double width = 1400;
	private GraphicsContext gc;
	private Player p1 = new Player(height/2);
	private Player p2 = new Player(height/2);
	private KeyController keyPressedController = new KeyController(p1, p2, true);
	private KeyController keyReleasedController = new KeyController(p1, p2, false);
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = new Pane();
			Canvas canvas = new Canvas(width, height);
			gc = canvas.getGraphicsContext2D();
			root.getChildren().add(canvas);
			Scene scene = new Scene(root);
			scene.setOnKeyPressed(keyPressedController);
			scene.setOnKeyReleased(keyReleasedController);
			Timeline tl = new Timeline(new KeyFrame(Duration.millis(33), e -> {p1.move(); p2.move(); drawCanvas();}));
			tl.setCycleCount(Timeline.INDEFINITE);
			tl.play();
			primaryStage.setTitle("Pong");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void drawCanvas() {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, width, height);
		gc.setFill(Color.WHITE);
		gc.setStroke(Color.WHITE);
		gc.fillRect(20, p1.getY(), 10, 100);
		gc.fillRect(width-20-10, p2.getY(), 10, 100);
		//gc.fillRect(ball.getX(), ball.getY(), 10, 10);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
