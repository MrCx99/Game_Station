/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_station;

/**
 *
 * @author aws-a
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.Timer;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Pep_ball_gameplay extends JPanel implements KeyListener, ActionListener {

    private boolean play = false;
    private int score = 0;
    private int totalBrick = 21;

    private int delay = 1;
    private Timer timer;
    private int PlayerX = 310;
    private int ballX = 120;
    private int ballY = 350;
    private int ballXdir = -1;
    private int ballYdir = -2;
    private Pepball_map map;

    public Pep_ball_gameplay() {

        map = new Pepball_map(3, 7);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        try {
            FileInputStream sound = new FileInputStream(new File("resources\\sound\\pip_ball\\nier.wav"));
            AudioStream IMusic = new AudioStream(sound);
            AudioPlayer.player.start(IMusic);
        } catch (IOException x) {
            System.out.println("No note in this JButton please check the notes file 1");

        }
        timer = new Timer(delay, this);
        timer.start();

    }

    public void paint(Graphics g) {

        //backgrund
        g.setColor(Color.black);
        g.fillRect(1, 1, 700, 600);
        //map
        map.draw((Graphics2D) g);
        //bordars
        g.setColor(Color.black);
        g.fillRect(0, 0, 3, 600);
        g.fillRect(0, 0, 700, 3);
        g.fillRect(0, 0, 3, 600);
        //score
        g.setColor(Color.white);
        g.setFont(new Font("serif", Font.BOLD, 25));
        g.drawString("" + score, 590, 30);
        //the paddle
        g.setColor(Color.green);
        g.fillRect(PlayerX, 550, 100, 8);
        //ball
        g.setColor(Color.yellow);
        g.fillOval(ballX, ballY, 20, 20);

        if (totalBrick <= 0) {

            play = false;
            ballXdir = 0;
            ballYdir = 0;
            g.setColor(Color.RED);

            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("Congratulation : ", 190, 300);

            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("prss enter to play again : ", 230, 400);

        }

        if (ballY >= 570) {

            play = false;
            ballXdir = 0;
            ballYdir = 0;
            g.setColor(Color.RED);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("GG : ", 190, 300);

            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("prss enter to play again : ", 230, 400);

        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (PlayerX >= 600) {
                PlayerX = 600;
            } else {
                moveRight();
            }
        }
        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
            if (PlayerX < 10) {
                PlayerX = 10;
            } else {
                moveLeft();
            }
        }
        if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!play) {
                play = true;
            }
            ballX = 120;
            ballY = 150;
            ballXdir = -1;
            ballYdir = -2;
            PlayerX = 310;
            score = 0;
            totalBrick = 21;
            map = new Pepball_map(3, 7);

            repaint();
        }
    }

    public void moveRight() {
        play = true;
        PlayerX += 20;
    }

    public void moveLeft() {
        play = true;
        PlayerX -= 20;
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        timer.start();
        if (play) {
            if (new Rectangle(ballX, ballY, 20, 20).intersects(new Rectangle(PlayerX, 550, 100, 8))) {
                ballYdir = -ballYdir;
                try {
                    FileInputStream sound = new FileInputStream(new File("resources\\sound\\pip_ball\\8bitgame10.wav"));
                    AudioStream IMusic = new AudioStream(sound);
                    AudioPlayer.player.start(IMusic);
                } catch (IOException x) {
                    System.out.println("No note in this JButton please check the notes file");

                }

            }
            A:
            for (int i = 0; i < map.map.length; i++) {
                for (int j = 0; j < map.map[0].length; j++) {
                    if (map.map[i][j] > 0) {
                        int brickX = j * map.brickWidth + 80;
                        int brickY = i * map.brickHeight + 50;
                        int brickWidth = map.brickWidth;
                        int brickHeight = map.brickHeight;

                        Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                        Rectangle ballrect = new Rectangle(ballX, ballY, 20, 20);
                        Rectangle brickREct = rect;
                        if (ballrect.intersects(brickREct)) {
                            map.setBrickValue(0, i, j);
                            totalBrick--;
                            score += 5;

                            if (ballX + 19 <= brickREct.x || ballX + 1 >= ballrect.x + brickREct.width) {
                                ballXdir = -ballXdir;
                                try {
                                    FileInputStream sound = new FileInputStream(new File("resources\\sound\\pip_ball\\8bitgame10.wav"));
                                    AudioStream IMusic = new AudioStream(sound);
                                    AudioPlayer.player.start(IMusic);
                                } catch (IOException x) {
                                    System.out.println("No note in this JButton please check the notes file");

                                }

                            } else {
                                ballYdir = -ballYdir;
                                try {
                                    FileInputStream sound = new FileInputStream(new File("resources\\sound\\pip_ball\\8bitgame10.wav"));
                                    AudioStream IMusic = new AudioStream(sound);
                                    AudioPlayer.player.start(IMusic);
                                } catch (IOException x) {
                                    System.out.println("No note in this JButton please check the notes file");

                                }
                            }

                        }

                    }
                }
            }
            ballX += ballXdir;
            ballY += ballYdir;
            if (ballX < 0) {
                ballXdir = -ballXdir;
            }
            if (ballY < 0) {
                ballYdir = -ballYdir;
            }
            if (ballX > 670) {
                ballXdir = -ballXdir;
            }
        }
        repaint();
    }

}

