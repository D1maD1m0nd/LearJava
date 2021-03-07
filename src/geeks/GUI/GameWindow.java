package geeks.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameWindow extends JFrame {
    private static GameWindow game_window;
    private static long lastFrameTime;
    private static Image background;
    private static Image gameOver;
    private static Image drop;
    private static float drop_left = 200;
    private static float drop_top = -100;
    private static float dropV = 200;

    public static void main(String[] args) throws IOException {
        background = ImageIO.read(GameWindow.class.getResourceAsStream("background.png"));
        gameOver = ImageIO.read(GameWindow.class.getResourceAsStream("game_over.png"));
        drop = ImageIO.read(GameWindow.class.getResourceAsStream("drop.png"));
        game_window = new GameWindow();
        game_window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //точка появления окна
        game_window.setLocation(200,100);
        //размерность
        game_window.setSize(906,478);
        //запрет изменения
        game_window.setResizable(false);
        lastFrameTime = System.nanoTime();
        GameField game_field = new GameField();
        game_window.add(game_field);
        //видимость окна
        game_window.setVisible(true);
    }

    private static void onRepaint(Graphics g){
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        lastFrameTime = currentTime;
        drop_top = drop_top + dropV * deltaTime;
        drop_left = drop_left + dropV * deltaTime;
        g.drawImage(background,0,0,null);
       // g.drawImage(gameOver,280,120,null);
        g.drawImage(drop,(int)drop_left,(int)drop_top,null);


    }
    private static class GameField extends JPanel{
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            onRepaint(g);
            repaint();
        }
    }
}
