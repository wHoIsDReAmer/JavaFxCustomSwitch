package customswitch.ui;

import javafx.animation.FillTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CustomSwitch extends Parent {
	private SimpleBooleanProperty checked = new SimpleBooleanProperty(false);
	private SimpleDoubleProperty size = new SimpleDoubleProperty(5);
	
	private Circle tr;
	private Rectangle bg;
	
	private Runnable runnable = new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}

	};
	
	public void setSize(double size) {
		this.size.set(size);
		
		bg.setWidth(9 * size);
		bg.setHeight(5 * size);
		bg.setArcHeight(5 * size);
		bg.setArcWidth(5 * size);
		bg.setStroke(Color.LIGHTGRAY);
		
		tr.setRadius(2.3 * size);
		tr.minWidth(2.3 * size);
		tr.setCenterX(2.5 * size);
		tr.setCenterY(2.5 * size);
		
		if (checked.get())
			tr.setTranslateX(9 * size - 5 * this.size.get());
	}
	
	public double getSize() {
		return size.get();
	}
	
	public boolean isChecked() {
		return checked.get();
	}
	
	public void setChecked(boolean bool) {
		this.checked.set(bool);
		if (bool) {
			tr.setTranslateX(9 * size.get() - 5 * size.get());
			bg.setFill(Color.rgb(20, 240, 20));
		} else {
			tr.setTranslateX(0);
			bg.setFill(Color.rgb(240, 120, 120));
		}
	}
	
	public void setOnAction(Runnable runnable) {
		this.runnable = runnable;
	}
	
	private TranslateTransition anime = new TranslateTransition(Duration.seconds(0.2));
	private FillTransition ct = new FillTransition(Duration.seconds(0.2));
	
	public CustomSwitch() {
		bg = new Rectangle(9 * size.get(), 5 * size.get());
		bg.setFill(checked.get() ? Color.rgb(20, 240, 20) : Color.rgb(240, 120, 120));
		bg.setArcHeight(5 * size.get());
		bg.setArcWidth(5 * size.get());
		bg.setStroke(Color.LIGHTGRAY);
		
		tr = new Circle(2.3 * size.get());
		tr.setCenterX(2.5 * size.get());
		tr.setCenterY(2.5 * size.get());
		tr.setStroke(Color.LIGHTGRAY);
		tr.setFill(Color.WHITE);
		
		if (checked.get())
			tr.setTranslateX(5 * size.get());
		
		tr.setOnMouseClicked(e -> {
			if (checked.get() == false) {
				anime.setNode(tr);
				anime.setToX(9 * size.get() - 5 * size.get());
				anime.play();
				
				ct.setShape(bg);
				ct.setToValue(Color.rgb(20, 240, 20));
				ct.play();
			} else {
				anime.setNode(tr);
				anime.setToX(0);
				anime.play();
				
				ct.setShape(bg);
				ct.setToValue(Color.rgb(240, 120, 120));
				ct.play();
			}
			
			checked.set(!checked.get());
			runnable.run();
		});
		
		getChildren().addAll(bg, tr);
	}
	
	public static void main(String[] args) {
		
	}
}
