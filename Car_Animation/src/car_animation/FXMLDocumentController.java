/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car_animation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

/**
 *
 * @author ahmed
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private ImageView imageView;

    @FXML
    private AnchorPane anchor;
    int reverser = 1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            //imageView.setImage(new Image(new FileInputStream("C:\\Users\\ahmed\\Documents\\NetBeansProjects\\Car_Animation\\src\\car_animation\\city-car-128.png")));
            imageView.setImage(new Image(new FileInputStream("city-car-128.png")));

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        Path path = new Path();
        path.getElements().add(new MoveTo(100, 100));
        path.getElements().add(new LineTo(300, 100));
        path.getElements().add(new LineTo(500, 300));
        path.getElements().add(new LineTo(700, 300));
        path.getElements().add(new CubicCurveTo(750, 250, 750, 150, 700, 100));

        path.getElements().add(new LineTo(500, 100));
        path.getElements().add(new LineTo(300, 300));
        path.getElements().add(new LineTo(100, 300));
        path.getElements().add(new CubicCurveTo(50, 250, 50, 150, 100, 100));

        //path.getElements().add(new CubicCurveTo(0,120,0,240,380,240));
        PathTransition pathTransion = new PathTransition();
        pathTransion.setDuration(Duration.millis(12000));
        pathTransion.setPath(path);
        pathTransion.setNode(imageView);
        pathTransion.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransion.setCycleCount(Timeline.INDEFINITE);
//        pathTransion.setAutoReverse(true);
        pathTransion.play();

        AnchorPane.setTopAnchor(path, 170d);
        AnchorPane.setLeftAnchor(path, 100d);

        path.setStrokeWidth(5);
        path.getStrokeDashArray().addAll(10.0, 10.0);
        path.setStroke(Color.WHITE);
        anchor.getChildren().add(path);

        String media_URL = "C:\\Users\\ahmed\\Desktop\\Car+Alarm.mp3";
        File file = new File(media_URL);
        final AudioClip clip = new AudioClip(file.toURI().toString());
        imageView.setOnMouseClicked((event) -> {
            clip.play();
            pathTransion.setRate(reverser);
            reverser *= -1;
        });

    }

}
