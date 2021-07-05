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
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class snake_gameplay extends JPanel implements KeyListener, ActionListener {

    Image img;
    private ImageIcon titleImge;
    private int[] snakexlength = new int[750];
    private int[] snakeylength = new int[750];
    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean douwn = false;
    private ImageIcon leftmouthe;
    private ImageIcon upmouthe;
    private ImageIcon douwnmouthe;
    private ImageIcon rightmouthe;
    private ImageIcon back;
    private Timer timer;
    private int moves = 0;
    private int score = 0;
    private int delay = 100;
    private int[] enemyxpos = {25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 625, 650, 675, 700, 725, 750, 775, 800, 825, 850
    };
    private int[] enemyypos = {75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 625};
    private ImageIcon enemyImage;
    private Random random = new Random();
    private int xpos = random.nextInt(34);
    private int ypos = random.nextInt(23);

    private ImageIcon snakeimge;
    private int lengthforsnake = 3;
    JButton home = new JButton();

  

    public snake_gameplay() {

      

        try {
            FileInputStream sound = new FileInputStream(new File("resources\\sound\\snake\\lala.wav"));
            AudioStream IMusic = new AudioStream(sound);
            AudioPlayer.player.start(IMusic);
        } catch (IOException x) {
            System.out.println("No note in this JButton please check the notes file 1");

        }

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();

    }

    public void paint(Graphics g) {

        if (moves == 0) {
            snakexlength[2] = 50;
            snakexlength[1] = 75;
            snakexlength[0] = 100;

            snakeylength[2] = 100;
            snakeylength[1] = 100;
            snakeylength[0] = 100;

        }

        titleImge = new ImageIcon("resources\\image\\snake\\UJ_sanke.png");
        titleImge.paintIcon(this, g, 25, 11);
        //draw border for gameplay
        g.setColor(Color.white);
        g.drawRect(24, 74, 851, 577);
        //draw score
        g.setColor(Color.white);
        g.setFont(new Font("arial", Font.PLAIN, 14));
        g.drawString("Score: " + score, 770, 45);

        g.setColor(Color.white);
        g.setFont(new Font("arial", Font.PLAIN, 14));
        g.drawString("length: " + lengthforsnake, 780, 500);
        //draw background for the game

        g.setColor(Color.black);
        g.fillRect(25, 75, 850, 575);

        rightmouthe = new ImageIcon("resources\\image\\snake\\up.png");
        rightmouthe.paintIcon(this, g, snakexlength[0], snakeylength[0]);
        for (int a = 0; a < lengthforsnake; a++) {
            if (a == 0 && right) {
                rightmouthe = new ImageIcon("resources\\image\\snake\\up.png");
                rightmouthe.paintIcon(this, g, snakexlength[a], snakeylength[a]);
            }
            if (a == 0 && left) {
                leftmouthe = new ImageIcon("resources\\image\\snake\\up.png");
                leftmouthe.paintIcon(this, g, snakexlength[a], snakeylength[a]);
            }
            if (a == 0 && douwn) {
                douwnmouthe = new ImageIcon("resources\\image\\snake\\up.png");
                douwnmouthe.paintIcon(this, g, snakexlength[a], snakeylength[a]);
            }
            if (a == 0 && up) {
                upmouthe = new ImageIcon("resources\\image\\snake\\up.png");
                upmouthe.paintIcon(this, g, snakexlength[a], snakeylength[a]);
            }
            if (a != 0) {
                snakeimge = new ImageIcon("resources\\image\\snake\\body.png");
                snakeimge.paintIcon(this, g, snakexlength[a], snakeylength[a]);
            }
        }
        enemyImage = new ImageIcon("resources\\image\\snake\\food.png");
        if ((enemyxpos[xpos]) == snakexlength[0] && enemyypos[ypos] == snakeylength[0]) {
            try {
                FileInputStream sound = new FileInputStream(new File("resources\\sound\\snake\\fed.wav"));
                AudioStream IMusic = new AudioStream(sound);
                AudioPlayer.player.start(IMusic);
            } catch (IOException x) {
                System.out.println("No note in this JButton please check the notes file");

            }

            score += 10;
            lengthforsnake++;
            xpos = random.nextInt(34);
            ypos = random.nextInt(23);
        }
        enemyImage.paintIcon(this, g, enemyxpos[xpos], enemyypos[ypos]);

        for (int b = 1; b < lengthforsnake; b++) {
            if (snakexlength[b] == snakexlength[0] && snakeylength[b] == snakeylength[0]) {
                InputStream sound;
                try {
                    sound = new FileInputStream(new File("resources\\sound\\snake\\hit.wav"));
                    AudioStream IMusic = new AudioStream(sound);
                    AudioPlayer.player.start(IMusic);
                } catch (IOException x) {
                    System.out.println("No note in this JButton please check the notes file");

                }
                right = false;
                left = false;
                douwn = false;
                up = false;

                g.setColor(Color.white);
                g.setFont(new Font("arial", Font.BOLD, 50));
                g.drawString("Game Over", 300, 300);

                g.setColor(Color.white);
                g.setFont(new Font("arial", Font.BOLD, 50));
                g.drawString("Space to RESTART", 350, 350);
            }
        }

        g.dispose();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == home) {
            new Game_station();
            setVisible(false);
        }
        timer.start();
        if (right) {
            for (int r = lengthforsnake - 1; r >= 0; r--) {
                snakeylength[r + 1] = snakeylength[r];
            }
            for (int r = lengthforsnake; r >= 0; r--) {
                if (r == 0) {
                    snakexlength[r] = snakexlength[r] + 25;
                } else {
                    snakexlength[r] = snakexlength[r - 1];
                }
                if (snakexlength[r] > 850) {
                    snakexlength[r] = 25;
                }
            }
            repaint();
        }
        if (left) {
            for (int r = lengthforsnake - 1; r >= 0; r--) {
                snakeylength[r + 1] = snakeylength[r];
            }
            for (int r = lengthforsnake; r >= 0; r--) {
                if (r == 0) {
                    snakexlength[r] = snakexlength[r] - 25;
                } else {
                    snakexlength[r] = snakexlength[r - 1];
                }
                if (snakexlength[r] < 25) {
                    snakexlength[r] = 850;
                }
            }
            repaint();
        }

        if (up) {
            for (int r = lengthforsnake - 1; r >= 0; r--) {
                snakexlength[r + 1] = snakexlength[r];
            }
            for (int r = lengthforsnake; r >= 0; r--) {
                if (r == 0) {
                    snakeylength[r] = snakeylength[r] - 25;
                } else {
                    snakeylength[r] = snakeylength[r - 1];
                }
                if (snakeylength[r] < 75) {
                    snakeylength[r] = 625;
                }
            }
            repaint();
        }

        if (douwn) {
            for (int r = lengthforsnake - 1; r >= 0; r--) {
                snakexlength[r + 1] = snakexlength[r];
            }
            for (int r = lengthforsnake; r >= 0; r--) {
                if (r == 0) {
                    snakeylength[r] = snakeylength[r] + 25;
                } else {
                    snakeylength[r] = snakeylength[r - 1];
                }
                if (snakeylength[r] > 625) {
                    snakeylength[r] = 75;
                }
            }
            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_SPACE) {
            moves = 0;
            score = 0;
            lengthforsnake = 3;
            repaint();

        }
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
            moves++;
            right = true;
            if (!left) {
                right = true;
            } else {
                right = false;
                left = true;
            }

            up = false;
            douwn = false;
        }
        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
            moves++;
            left = true;
            if (!right) {
                left = true;
            } else {
                left = false;
                right = true;
            }
            up = false;
            douwn = false;
        }
        if (ke.getKeyCode() == KeyEvent.VK_UP) {
            moves++;
            up = true;
            if (!douwn) {
                up = true;
            } else {
                douwn = true;
                up = false;

            }
            left = false;
            right = false;
        }
        if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
            moves++;
            douwn = true;
            if (!up) {
                douwn = true;
            } else {

                up = true;
                douwn = false;
            }
            left = false;
            right = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

}
