package geeks.GUI;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private static GameWindow game_window;
    public static void main(String[] args) {
        game_window = new GameWindow();
        game_window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //точка появления окна
        game_window.setLocation(200,100);
        //размерность
        game_window.setSize(950,500);
        //запрет изменения
        game_window.setResizable(false);
        GameField game_field = new GameField();
        game_window.add(game_field);
        //видимость окна
        game_window.setVisible(true);
    }

    private static void onRepaint(Graphics g){
        g.fillOval(10,10,200,100);
        g.drawLine(200,200,300,200);

    }
    private static class GameField extends JPanel{
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            onRepaint(g);
        }
    }
}
