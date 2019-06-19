package sample;

import Level.BasicRoom;
import Objects.MainChar;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;

public class Controller {
    @FXML
    Canvas MainCanvas;
    private MainChar mainChar;
    private BasicRoom wallList;

    public void initialize() {
        wallList = new BasicRoom(MainCanvas.getGraphicsContext2D());
        mainChar = new MainChar(0, 450, 48, 48, MainCanvas.getGraphicsContext2D(), wallList);
        gameLoop();
    }


    public void gameLoop() {
        AnimationTimer animationTimer = new AnimationTimer() {

            @Override
            public void handle(long now) {
                addKeyInput(MainCanvas.getScene(), this);
                mainChar.redraw();
                wallList.drawRoom();
            }
        };
        animationTimer.start();
    }

    public void addKeyInput(Scene scene, AnimationTimer animationTimer) {
        scene.setOnKeyPressed((event) -> {
            //Nach Rechts bewegen
            if (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.D) {
                mainChar.moveRight();
                System.out.println("RIGHT");
            }
            //Nach Links bewegen
            if (event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.A) {
                mainChar.moveLeft();
                System.out.println("LEFT");
            }
            //nach Oben
            if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {
                mainChar.moveUp();
                System.out.println("UP");
            }
            //nach Unten
            if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {
                mainChar.moveDown();
                System.out.println("DOWN");
            }
        });


        scene.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.D) {
                mainChar.stopright();
            }
            if (event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.A) {
                mainChar.stopleft();
            }
            if (event.getCode() == KeyCode.UP || event.getCode() == KeyCode.W) {
                mainChar.stopup();
            }
            if (event.getCode() == KeyCode.DOWN || event.getCode() == KeyCode.S) {
                mainChar.stopdown();
            }
        });
    }

}