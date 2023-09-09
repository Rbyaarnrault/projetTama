package vue;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class TamagotchiAnimationFX extends Pane {
    private Circle tamagotchi;

    public TamagotchiAnimationFX() {
        tamagotchi = new Circle(50, 50, 30);

        Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(500), e -> {
                    tamagotchi.setRadius(tamagotchi.getRadius() == 30 ? 20 : 30);
                }));
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();

        getChildren().add(tamagotchi);
    }
}
