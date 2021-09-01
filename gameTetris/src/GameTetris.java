import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
/* Этот код я писал с видео на youtube по ссылке https://www.youtube.com/watch?v=sCit9jzDSrE
код написан в целях обучения языка программирования Java
 */


public class GameTetris {
    final String TITLE_FROM_PROGRAM = "Tetris";
    final int BLOCK_SIZE = 25;
    final int ARC_RADIUS = 6;
    final int FIEALD_WIDTH = 10;
    final int FIEALD_HEIGHT = 20;
    final int START_LOCATION = 180;
    final int FIELD_DX = 7;
    final int FIELD_DY = 26;
    final int LEFT = 37;
    final int UP = 38;
    final int RIGHT = 39;
    final int DOWN = 40;
    final int SHOW_DELAY = 350; //задержка анимации

    final int[][][] SHAPES = {
            {{0,0,0,0}, {1,1,1,1}, {0,0,0,0}, {0,0,0,0}, {4, 0x00f0f0}}, // I
            {{0,0,0,0}, {0,1,1,0}, {0,1,1,0}, {0,0,0,0}, {4, 0xf0f000}}, // O
            {{1,0,0,0}, {1,1,1,0}, {0,0,0,0}, {0,0,0,0}, {3, 0x0000f0}}, // J
            {{0,0,1,0}, {1,1,1,0}, {0,0,0,0}, {0,0,0,0}, {3, 0xf0a000}}, // L
            {{0,1,1,0}, {1,1,0,0}, {0,0,0,0}, {0,0,0,0}, {3, 0x00f000}}, // S
            {{1,1,1,0}, {0,1,0,0}, {0,0,0,0}, {0,0,0,0}, {3, 0xa000f0}}, // T
            {{1,1,0,0}, {0,1,1,0}, {0,0,0,0}, {0,0,0,0}, {3, 0xf00000}}  // Z
    };//изображение фигур

    final int [] SCORES = {100, 300 ,500 ,1500}; // количество очков при сжигании поля когда фигура заполняет ряд
    int gameScores = 0 ; // счетчик очков от SCORES
    int [][] fieald = new int[FIEALD_HEIGHT][FIEALD_WIDTH]; // размер поля(шахты) куда падают фигуры
    JFrame frame;
    Canvas canvasPanel = new Canvas();
    Random random = new Random();// создали объект генератора случайных чисел
    Figure figure = new Figure();// создаем объект класса Figure
    boolean gameOver = false;
    final int[][] GAME_OVER_MSG = {
            {0,1,1,0,0,0,1,1,0,0,0,1,0,1,0,0,0,1,1,0},
            {1,0,0,0,0,1,0,0,1,0,1,0,1,0,1,0,1,0,0,1},
            {1,0,1,1,0,1,1,1,1,0,1,0,1,0,1,0,1,1,1,1},
            {1,0,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,0,0},
            {0,1,1,0,0,1,0,0,1,0,1,0,1,0,1,0,0,1,1,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,1,0,0,1,0,0,1,0,0,1,1,0,0,1,1,1,0,0},
            {1,0,0,1,0,1,0,0,1,0,1,0,0,1,0,1,0,0,1,0},
            {1,0,0,1,0,1,0,1,0,0,1,1,1,1,0,1,1,1,0,0},
            {1,0,0,1,0,1,1,0,0,0,1,0,0,0,0,1,0,0,1,0},
            {0,1,1,0,0,1,0,0,0,0,0,1,1,0,0,1,0,0,1,0}}; // надпись gameOver



    public static void main(String[] args) {
        //Создаем объекта нашего класса GameTetris и вызываем у него метод go()
        new GameTetris().go();
    }

    void go(){

        frame = new JFrame(TITLE_FROM_PROGRAM);// создаем объект frame и передаем ему в конструктор имя программы
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // вызываем метод объекта frame и передаем в конструктор константу закрытия окна
        frame.setSize(FIEALD_WIDTH * BLOCK_SIZE +FIELD_DX,FIEALD_HEIGHT*BLOCK_SIZE + FIELD_DY);// задаем размер
        frame.setLocation(START_LOCATION,START_LOCATION);
        frame.setResizable(false);//размер окна нельзя будет менять
        canvasPanel.setBackground(Color.BLACK);// задаем цвет фона окна
        frame.setVisible(true);// показывает окно нам
    }
}
