/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_station;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
// MouseListener: mouse event  , MouseMotionListener: movment

public class chess extends JFrame implements MouseListener, MouseMotionListener, ActionListener {

    JLayeredPane Panel_layer;
    JPanel J_chessBoard;
    JLabel J_chessPiece;
    int the_xis;
    private Container Container;
    int the_yis;
    int xx, yy;
    int dx, dy;
    int x, y;
    ImageIcon menu_pic = new ImageIcon("resources\\image\\chess\\111.png");
    JButton home = new JButton();

    JPanel title = new JPanel();

    public chess() {
        BufferedImage image;
        try {
            image = ImageIO.read(new File("resources\\image\\chess\\chesso.png"));
            JLabel label = new JLabel(new ImageIcon(image));
            title.add(label);
        } catch (IOException ex) {
            Logger.getLogger(chess.class.getName()).log(Level.SEVERE, null, ex);
        }

        setSize(950, 839);
        Dimension boardSize = new Dimension(800, 800);
        Container = getContentPane();
        home.setIcon(menu_pic);
        home.addActionListener(this);
        add(home).setBounds(815, 720, 100, 50);
        home.setBackground(new Color(106, 75, 53));
        add(title).setBounds(795, -10, 146, 830);
        home.setBorderPainted(false);

        setTitle("Chess");
        // setResizable(false);

        // Layer panel and set size
        Panel_layer = new JLayeredPane();
        getContentPane().add(Panel_layer);
        Panel_layer.setPreferredSize(boardSize);

        Panel_layer.addMouseListener(this);
        Panel_layer.addMouseMotionListener(this);

        // Add a chess board to the Layered Pane 
        J_chessBoard = new JPanel();
        Panel_layer.add(J_chessBoard, JLayeredPane.DEFAULT_LAYER);
        J_chessBoard.setLayout(new GridLayout(8, 8));
        J_chessBoard.setPreferredSize(boardSize);
        J_chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);

        // moving pieces on board:
        boolean flag = false;

        // X 
        for (int j = 0; j < 8; j++) {
            if (j % 2 == 0) {
                flag = false;
            } else if (j % 2 == 1) {
                flag = true;
            }
            // +
            for (int i = 0; i < 8; i++) {
                JPanel square = new JPanel(new BorderLayout());
                J_chessBoard.add(square);

                if (flag == true) {
                    square.setBackground(i % 2 == 0 ? new Color(72, 50, 34) : new Color(197, 174, 158));
                } else {
                    square.setBackground(i % 2 == 0 ? new Color(197, 174, 158) : new Color(72, 50, 34));
                }
            }

        }

        // Black pieces
        JLabel label1 = new JLabel(new ImageIcon("resources\\image\\chess\\rook.png"));
        JPanel panel1 = (JPanel) J_chessBoard.getComponent(0);
        panel1.add(label1);
        JLabel label2 = new JLabel(new ImageIcon("resources\\image\\chess\\chesss.png"));
        JPanel panel2 = (JPanel) J_chessBoard.getComponent(1);
        panel2.add(label2);
        JLabel label = new JLabel(new ImageIcon("resources\\image\\chess\\bishop-chess-piece.png"));
        JPanel panel = (JPanel) J_chessBoard.getComponent(2);
        panel.add(label);
        JLabel label3 = new JLabel(new ImageIcon("resources\\image\\chess\\chess-king.png"));
        JPanel panel3 = (JPanel) J_chessBoard.getComponent(3);
        panel3.add(label3);
        JLabel label4 = new JLabel(new ImageIcon("resources\\image\\chess\\queen-chess-piece-black-shape.png"));
        JPanel panel4 = (JPanel) J_chessBoard.getComponent(4);
        panel4.add(label4);
        JLabel label5 = new JLabel(new ImageIcon("resources\\image\\chess\\chesss.png"));
        JPanel panel5 = (JPanel) J_chessBoard.getComponent(6);
        panel5.add(label5);
        JLabel label6 = new JLabel(new ImageIcon("resources\\image\\chess\\bishop-chess-piece.png"));
        JPanel panel6 = (JPanel) J_chessBoard.getComponent(5);
        panel6.add(label6);
        JLabel label7 = new JLabel(new ImageIcon("resources\\image\\chess\\rook.png"));
        JPanel panel7 = (JPanel) J_chessBoard.getComponent(7);
        panel7.add(label7);
        JLabel label8 = new JLabel(new ImageIcon("resources\\image\\chess\\chess-pawn.png"));
        JPanel panel8 = (JPanel) J_chessBoard.getComponent(8);
        panel8.add(label8);
        JLabel label9 = new JLabel(new ImageIcon("resources\\image\\chess\\chess-pawn.png"));
        JPanel panel9 = (JPanel) J_chessBoard.getComponent(9);
        panel9.add(label9);
        JLabel label10 = new JLabel(new ImageIcon("resources\\image\\chess\\chess-pawn.png"));
        JPanel panel10 = (JPanel) J_chessBoard.getComponent(10);
        panel10.add(label10);
        JLabel label11 = new JLabel(new ImageIcon("resources\\image\\chess\\chess-pawn.png"));
        JPanel panel11 = (JPanel) J_chessBoard.getComponent(11);
        panel11.add(label11);
        JLabel label12 = new JLabel(new ImageIcon("resources\\image\\chess\\chess-pawn.png"));
        JPanel panel12 = (JPanel) J_chessBoard.getComponent(12);
        panel12.add(label12);
        JLabel label13 = new JLabel(new ImageIcon("resources\\image\\chess\\chess-pawn.png"));
        JPanel panel13 = (JPanel) J_chessBoard.getComponent(13);
        panel13.add(label13);
        JLabel label14 = new JLabel(new ImageIcon("resources\\image\\chess\\chess-pawn.png"));
        JPanel panel14 = (JPanel) J_chessBoard.getComponent(14);
        panel14.add(label14);
        JLabel label15 = new JLabel(new ImageIcon("resources\\image\\chess\\chess-pawn.png"));
        JPanel panel15 = (JPanel) J_chessBoard.getComponent(15);
        panel15.add(label15);

        // white pieces:
        JLabel label48 = new JLabel(new ImageIcon("resources\\image\\chess\\bishop.png"));
        JPanel panel48 = (JPanel) J_chessBoard.getComponent(49);
        panel48.add(label48);
        JLabel label49 = new JLabel(new ImageIcon("resources\\image\\chess\\bishop.png"));
        JPanel panel49 = (JPanel) J_chessBoard.getComponent(48);
        panel49.add(label49);
        JLabel labe50 = new JLabel(new ImageIcon("resources\\image\\chess\\bishop.png"));
        JPanel pane50 = (JPanel) J_chessBoard.getComponent(50);
        pane50.add(labe50);
        JLabel labe51 = new JLabel(new ImageIcon("resources\\image\\chess\\bishop.png"));
        JPanel pane51 = (JPanel) J_chessBoard.getComponent(51);
        pane51.add(labe51);
        JLabel label52 = new JLabel(new ImageIcon("resources\\image\\chess\\bishop.png"));
        JPanel panel52 = (JPanel) J_chessBoard.getComponent(51);
        panel52.add(label52);
        JLabel labe53 = new JLabel(new ImageIcon("resources\\image\\chess\\bishop.png"));
        JPanel pane53 = (JPanel) J_chessBoard.getComponent(52);
        pane53.add(labe53);
        JLabel labe54 = new JLabel(new ImageIcon("resources\\image\\chess\\bishop.png"));
        JPanel pane54 = (JPanel) J_chessBoard.getComponent(53);
        pane54.add(labe54);
        JLabel labe55 = new JLabel(new ImageIcon("resources\\image\\chess\\bishop.png"));
        JPanel pane55 = (JPanel) J_chessBoard.getComponent(54);
        pane55.add(labe55);
        JLabel labe56 = new JLabel(new ImageIcon("resources\\image\\chess\\bishop.png"));
        JPanel pane56 = (JPanel) J_chessBoard.getComponent(55);
        pane56.add(labe56);
        JLabel labe57 = new JLabel(new ImageIcon("resources\\image\\chess\\chess.png"));
        JPanel pane57 = (JPanel) J_chessBoard.getComponent(56);
        pane57.add(labe57);
        JLabel label58 = new JLabel(new ImageIcon("resources\\image\\chess\\bishop-chess-piece-outline.png"));
        JPanel panel58 = (JPanel) J_chessBoard.getComponent(58);
        panel58.add(label58);
        JLabel label59 = new JLabel(new ImageIcon("resources\\image\\chess\\chess1.png"));
        JPanel panel59 = (JPanel) J_chessBoard.getComponent(57);
        panel59.add(label59);
        JLabel label60 = new JLabel(new ImageIcon("resources\\image\\chess\\chess-piece.png"));
        JPanel panel60 = (JPanel) J_chessBoard.getComponent(60);
        panel60.add(label60);
        JLabel label61 = new JLabel(new ImageIcon("resources\\image\\chess\\queen.png"));
        JPanel panel61 = (JPanel) J_chessBoard.getComponent(59);
        panel61.add(label61);
        JLabel label62 = new JLabel(new ImageIcon("resources\\image\\chess\\chess1.png"));
        JPanel panel62 = (JPanel) J_chessBoard.getComponent(62);
        panel62.add(label62);
        JLabel label63 = new JLabel(new ImageIcon("resources\\image\\chess\\bishop-chess-piece-outline.png"));
        JPanel panel63 = (JPanel) J_chessBoard.getComponent(61);
        panel63.add(label63);
        JLabel label64 = new JLabel(new ImageIcon("resources\\image\\chess\\chess.png"));
        JPanel panel64 = (JPanel) J_chessBoard.getComponent(63);
        panel64.add(label64);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //pack();

        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void mousePressed(MouseEvent e) {
        J_chessPiece = null;
        Component c = J_chessBoard.findComponentAt(e.getX(), e.getY());
        x = e.getX();
        y = e.getY();

        xx = (e.getX()) / 75;
        yy = (e.getY()) / 75;

        if (c instanceof JPanel) {
            return;
        }

        Point parentLocation = c.getParent().getLocation();
        the_xis = parentLocation.x - e.getX();
        the_yis = parentLocation.y - e.getY();
        J_chessPiece = (JLabel) c;
        J_chessPiece.setLocation(e.getX() + the_xis, e.getY() + the_yis);
        J_chessPiece.setSize(J_chessPiece.getWidth(), J_chessPiece.getHeight());
        Panel_layer.add(J_chessPiece, JLayeredPane.DRAG_LAYER);
    }

    //Move the chess piece around
    public void mouseDragged(MouseEvent me) {
        if (J_chessPiece == null) {
            return;
        }
        J_chessPiece.setLocation(me.getX() + the_xis, me.getY() + the_yis);
    }

    //Drop the chess piece back onto the chess board
    public void mouseReleased(MouseEvent e) {
        if (J_chessPiece == null) {
            return;
        }

        dx = (e.getX()) / 75;

        dy = (e.getY()) / 75;

//Here the main idea
        if ((xx == dx) || (yy == dy)) {
            J_chessPiece.setVisible(false);
            Component c = J_chessBoard.findComponentAt(e.getX(), e.getY());

            if (c instanceof JLabel) {
                Container parent = c.getParent();
                parent.remove(0);
                parent.add(J_chessPiece);
            } else {
                Container parent = (Container) c;
                parent.add(J_chessPiece);

            }
            J_chessPiece.setVisible(true);

        } else {
            J_chessPiece.setLocation(x + the_xis, y + the_yis);
        }

    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == home) {
            Game_station x = new Game_station();
            setVisible(false);
        }
    }

}
