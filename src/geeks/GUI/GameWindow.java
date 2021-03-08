package geeks.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Random;

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
        game_field.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                float dropRight = drop_left * drop.getWidth(null);
                float dropBottom = drop_top * drop.getHeight(null);
                boolean idDrop = x >= drop_left && x <= dropRight && y >= drop_top && y<= dropBottom;
                if(idDrop){
                    drop_top = -100;
                    drop_left = (int)(Math.random() * (game_field.getWidth() - drop.getWidth(null)));
                    dropV = dropV + 20;
                }
            }
        });
        game_window.add(game_field);
        //видимость окна
        game_window.setVisible(true);
    }

    private static void onRepaint(Graphics g){
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        lastFrameTime = currentTime;
        drop_top = drop_top + dropV * deltaTime;

        g.drawImage(background,0,0,null);
       // g.drawImage(gameOver,280,120,null);
        g.drawImage(drop,(int)drop_left,(int)drop_top,null);
        if(drop_top > game_window.getHeight()){
            g.drawImage(gameOver,280,120,null);
        }

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
