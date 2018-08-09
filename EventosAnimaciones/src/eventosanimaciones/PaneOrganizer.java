/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventosanimaciones;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;


public class PaneOrganizer {
    
    private Pane root;
    private Rectangle rectangle;
    private Timeline tl;
    
    public PaneOrganizer() {
        rectangle = new Rectangle(100, 100);
        root = new Pane();
        root.getChildren().add(rectangle);
        rectangle.setTranslateX(500);
        rectangle.setTranslateY(50); 
        tl = new Timeline();
        rectangle.setOnMouseClicked(e->{
            evtClick();
        }); 
        
        rectangle.setOnMouseDragged(e -> {
            rectangle.setTranslateX(e.getSceneX());
            rectangle.setTranslateY(e.getSceneY()); 
        }); 
        
    }
    
    private void evtClick(){
        KeyValue kv = new KeyValue(rectangle.translateYProperty(), 700);
        KeyFrame kf = new KeyFrame(Duration.millis(3000), e-> evento(), kv);
        tl.stop();
        tl.getKeyFrames().clear();
        tl.getKeyFrames().add(kf);
        tl.play();
    }
    
    private void evento() {
        KeyValue kv = new KeyValue(rectangle.translateYProperty(), 50);
        KeyFrame kf = new KeyFrame(Duration.millis(1000), e-> evento(), kv);
        tl.stop();
        tl.getKeyFrames().clear();
        tl.getKeyFrames().add(kf);
        tl.play();
    }
    public Pane getPane() {
        return root;
    }
    
    public Rectangle getRectangle() {
        return rectangle;
    }
}
