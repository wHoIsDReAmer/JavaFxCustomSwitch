package customswitch.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class test extends Application {
	@Override
	public void start(Stage arg0) throws Exception {
		Pane r = new Pane();
		r.setPrefSize(300, 300);
		
		CustomSwitch t = new CustomSwitch();
		t.setTranslateX(100);
		t.setTranslateY(100);
		t.setSize(10.0);
		t.setChecked(true);
		
		r.getChildren().addAll(t);
		
		arg0.setScene(new Scene(r));
		arg0.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
