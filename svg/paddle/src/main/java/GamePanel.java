package src.main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class GamePanel extends JPanel {
    public static final int WIDTH  = 640;
    public static final int HEIGHT = 800;
    private final Paddle paddle;
    private final Ball ball;
    private boolean gameStart =false;
    private Timer timer;
    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);

        GraphicsItem.setCanvasSize(WIDTH,HEIGHT);
        paddle = new Paddle();
        ball = new Ball();

        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent mouseEvent) {
                paddle.updatePosition(mouseEvent.getX());
                if(!gameStart) {
                    ball.setInitialPosition(paddle);
                    repaint();
                }
            }
        });
        timer = new Timer(10,e->update());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gameStart = true;
                timer.start();
            }
        });

    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D graphics2D = (Graphics2D) g;
        paddle.draw(graphics2D);
        ball.draw(graphics2D);
    }
    private void update(){
        if(gameStart){
            ball.move();
            checkCollisions();
            if(ball.isOutOfBounds()){
                timer.stop();;
                gameStart = false;
            }
            repaint();
        }
    }
    private void checkCollisions(){
        if(ball.getY()+ball.getHeight()/2>=paddle.getY()&& ball.getX()>=paddle.getX()&&ball.getX()<=paddle.getX() + paddle.getWidth()){
            ball.bounce();
        }
    }
}