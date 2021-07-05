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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import sun.audio.*;
import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.ImageIcon;

public class TicTacToe extends JFrame implements ActionListener {

    Random random = new Random();

    JPanel title_p = new JPanel();
    JPanel Panel_button = new JPanel();
    JPanel bo1 = new JPanel();
    JPanel bo2 = new JPanel();
    JPanel bo3 = new JPanel();
    JPanel bo4 = new JPanel();
    JPanel main = new JPanel();
    JLabel txt_score = new JLabel();
    JLabel txt_x = new JLabel();
    JLabel txt_o = new JLabel();
    JLabel txt = new JLabel();
    JButton restart = new JButton("Restart");
    JButton home = new JButton();
    JButton[] buttons = new JButton[9];
    boolean player1;
    int win_x = 0;
    int win_o = 0;

    ImageIcon menu_pic = new ImageIcon("resources\\image\\tic_tac\\home.png");
    ImageIcon x_pic = new ImageIcon("resources\\image\\tic_tac\\letter_x.png");
    ImageIcon o_pic = new ImageIcon("resources\\image\\tic_tac\\letter_o.png");

    ImageIcon reg = new ImageIcon("resources\\image\\tic_tac\\white\\0.png");
    ImageIcon reg1 = new ImageIcon("resources\\image\\tic_tac\\white\\1.png");
    ImageIcon reg2 = new ImageIcon("resources\\image\\tic_tac\\white\\2.png");
    ImageIcon reg3 = new ImageIcon("resources\\image\\tic_tac\\white\\3.png");
    ImageIcon reg4 = new ImageIcon("resources\\image\\tic_tac\\white\\4.png");
    ImageIcon reg5 = new ImageIcon("resources\\image\\tic_tac\\white\\5.png");
    ImageIcon reg6 = new ImageIcon("resources\\image\\tic_tac\\white\\6.png");
    ImageIcon reg7 = new ImageIcon("resources\\image\\tic_tac\\white\\7.png");
    ImageIcon reg8 = new ImageIcon("resources\\image\\tic_tac\\white\\8.png");

    public TicTacToe() throws IOException {

        setContentPane(new JLabel(new ImageIcon("resources\\image\\tic_tac\\backuj3.png")));

        home.setIcon(menu_pic);
        home.setBackground(Color.cyan);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 830);
        getContentPane().setBackground(Color.darkGray);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Tic-Tac-Toe");

        restart.addActionListener(this);
        home.addActionListener(this);

        txt_score.setFont(new Font("INK Free", Font.BOLD, 40));
        txt_x.setFont(new Font("INK Free", Font.BOLD, 40));
        txt_o.setFont(new Font("INK Free", Font.BOLD, 40));
        txt.setFont(new Font("INK Free", Font.BOLD, 40));

        txt_score.setText("Score");
        txt_x.setText("X = 0");
        txt_o.setText("O = 0");
        txt.setText("Tic-Tac-Toe");

        txt_score.setForeground(Color.black);
        txt_x.setForeground(Color.white);
        txt_o.setForeground(Color.white);
        txt.setForeground(Color.white);

        Panel_button.setLayout(new GridLayout(3, 3));
        Panel_button.setBackground(new Color(150, 150, 150));

        bo1.setBackground(new Color(0, 0, 0));
        bo2.setBackground(new Color(0, 0, 0));
        bo3.setBackground(new Color(0, 0, 0));
        bo4.setBackground(new Color(0, 0, 0));

        title_p.setBounds(100, 5, 500, 100);
        Panel_button.setBounds(50, 50, 700, 700);

        add(home).setBounds(848, 150, 60, 60);
        add(txt_score).setBounds(830, 250, 150, 30);
        add(txt_x).setBounds(830, 300, 150, 30);
        add(txt_o).setBounds(825, 350, 150, 30);
        add(restart).setBounds(830, 430, 100, 30);

        Panel_button.setBounds(50, 50, 700, 700);
        bo1.setBounds(45, 45, 5, 710);
        bo2.setBounds(750, 45, 5, 710);
        bo3.setBounds(45, 45, 710, 5);
        bo4.setBounds(45, 750, 710, 5);

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            Panel_button.add(buttons[i]);
            buttons[i].setFont(new Font("MV", Font.BOLD, 120));
            buttons[i].setFocusable(true);
            buttons[i].addActionListener(this);
            buttons[i].setBackground(Color.white);
            buttons[i].setBackground(new Color(0, 124, 180));

        }
        buttons[0].setIcon(reg);
        buttons[1].setIcon(reg1);
        buttons[2].setIcon(reg2);
        buttons[3].setIcon(reg3);
        buttons[4].setIcon(reg4);
        buttons[5].setIcon(reg5);
        buttons[6].setIcon(reg6);
        buttons[7].setIcon(reg7);
        buttons[8].setIcon(reg8);

        add(bo1);
        add(bo2);
        add(bo3);
        add(bo4);

        add(Panel_button);
        add(txt).setBounds(240, 300, 150, 30);
        firstTurn();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == home) {

            Game_station l = new Game_station();
            setVisible(false);

        } else if (ae.getSource() == restart) {
            for (int r = 0; r < 9; r++) {
                buttons[r].setEnabled(true);

                buttons[r].setBackground(new Color(0, 124, 180));
            }
            buttons[0].setIcon(reg);
            buttons[1].setIcon(reg1);
            buttons[2].setIcon(reg2);
            buttons[3].setIcon(reg3);
            buttons[4].setIcon(reg4);
            buttons[5].setIcon(reg5);
            buttons[6].setIcon(reg6);
            buttons[7].setIcon(reg7);
            buttons[8].setIcon(reg8);

        }

        for (int i = 0; i < 9; i++) {
            if (ae.getSource() == buttons[i]) {
                if (player1) {
                    if (buttons[i].getText() == "") {
                        InputStream sound;
                        try {
                            sound = new FileInputStream(new File("resources\\sound\\tic_tac\\click1.wav"));
                            AudioStream IMusic = new AudioStream(sound);
                            AudioPlayer.player.start(IMusic);
                        } catch (IOException a) {
                            System.out.println("No note in this JButton please check the notes file");

                        }
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setIcon(x_pic);////////////////////////////////////////////////////////////
                        player1 = false;

                        check();

                    }
                } else if (buttons[i].getText() == "") {
                    InputStream IAudio;
                    try {
                        IAudio = new FileInputStream(new File("resources\\sound\\tic_tac\\click1.wav"));
                        AudioStream IMusic = new AudioStream(IAudio);
                        AudioPlayer.player.start(IMusic);
                    } catch (IOException a) {
                        System.out.println("No note in this JButton please check the notes file");

                    }
                    buttons[i].setForeground(new Color(0, 0, 255));
                    buttons[i].setIcon(o_pic);//////////////////////////////////////////////////////////////////
                    player1 = true;

                    check();
                }
            }

        }

    }

    public void firstTurn() {
        if (random.nextInt(2) == 0) {
            player1 = true;

        } else {
            player1 = false;

        }
    }

    public void check() {

        if ((buttons[0].getIcon() == buttons[1].getIcon())
                && (buttons[0].getIcon() == buttons[2].getIcon())) {
            if (buttons[0].getIcon() == x_pic) {
                win_for_x(0, 1, 2);
            } else {
                win_for_o(0, 1, 2);
            }
        } else if ((buttons[3].getIcon() == buttons[4].getIcon())
                && (buttons[3].getIcon() == buttons[5].getIcon())) {
            if (buttons[3].getIcon() == x_pic) {
                win_for_x(3, 4, 5);
            } else {
                win_for_o(3, 4, 5);
            }
        } else if ((buttons[6].getIcon() == buttons[7].getIcon())
                && (buttons[6].getIcon() == buttons[8].getIcon())) {
            if (buttons[6].getIcon() == x_pic) {
                win_for_x(6, 7, 8);
            } else {
                win_for_o(6, 7, 8);
            }
        } else if ((buttons[0].getIcon() == buttons[3].getIcon())
                && (buttons[0].getIcon() == buttons[6].getIcon())) {
            if (buttons[0].getIcon() == x_pic) {
                win_for_x(0, 3, 6);
            } else {
                win_for_o(0, 3, 6);
            }
        } else if ((buttons[1].getIcon() == buttons[7].getIcon())
                && (buttons[1].getIcon() == buttons[4].getIcon())) {
            if (buttons[1].getIcon() == x_pic) {
                win_for_x(1, 4, 7);
            } else {
                win_for_o(1, 4, 7);
            }
        } else if ((buttons[2].getIcon() == buttons[5].getIcon())
                && (buttons[2].getIcon() == buttons[8].getIcon())) {
            if (buttons[2].getIcon() == x_pic) {
                win_for_x(2, 5, 8);
            } else {
                win_for_o(2, 5, 8);
            }
        } else if ((buttons[0].getIcon() == buttons[4].getIcon())
                && (buttons[0].getIcon() == buttons[8].getIcon())) {
            if (buttons[0].getIcon() == x_pic) {
                win_for_x(0, 4, 8);
            } else {
                win_for_o(0, 4, 8);
            }
        } else if ((buttons[2].getIcon() == buttons[4].getIcon())
                && (buttons[2].getIcon() == buttons[6].getIcon())) {
            if (buttons[2].getIcon() == x_pic) {
                win_for_x(2, 4, 6);
            } else {
                win_for_o(2, 4, 6);
            }
        }
    }

    public void win_for_x(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        win_x++;

        txt_x.setText("X = " + win_x);

        InputStream sound;
        try {
            sound = new FileInputStream(new File("resources\\sound\\tic_tac\\win.wav"));
            AudioStream IMusic = new AudioStream(sound);
            AudioPlayer.player.start(IMusic);
        } catch (IOException x) {
            System.out.println("No note in this JButton please check the notes file");

        }

    }

    public void win_for_o(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        win_o++;

        txt_o.setText("O = " + win_o);

        InputStream sound;
        try {
            sound = new FileInputStream(new File("resources\\sound\\tic_tac\\win.wav"));
            AudioStream IMusic = new AudioStream(sound);
            AudioPlayer.player.start(IMusic);
        } catch (IOException x) {
            System.out.println("No note in this JButton please check the notes file");

        }

    }

    public void no_one_win() {

    }

}
