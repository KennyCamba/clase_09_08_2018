/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventosanimaciones;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Municipio de Gye
 */
public class EventosAnimaciones extends Application {
    
    @Override
    public void start(Stage stage) {
        Rectangle rec = new Rectangle(100, 100);
        PaneOrganizer po = new PaneOrganizer();
        Scene sc = new Scene(po.getPane());
        stage.setScene(sc); 
        stage.show();
        sc.setOnKeyPressed(e-> {
            switch(e.getCode()) {
                case UP:
                    po.getRectangle().setTranslateY(po.getRectangle().getTranslateY() - 5); 
                    break;
                case DOWN:
                    po.getRectangle().setTranslateY(po.getRectangle().getTranslateY() + 5);
                    break;
                    
                case LEFT:
                    po.getRectangle().setTranslateX(po.getRectangle().getTranslateX() - 5);
                    break;
                case RIGHT:
                    po.getRectangle().setTranslateX(po.getRectangle().getTranslateX() + 5);
                    break;
            }
        }); 
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
