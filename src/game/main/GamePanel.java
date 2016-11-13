package game.main;

import game.gamestates.GameStateManager;
import game.resources.Images;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener{

	static final long serialVersionUID = 1;
	
	//The width and height of the panel
	public static final int WIDTH = 1200;
	public static final int HEIGHT = 700;
	
	//The thread that keeps the whole thing running
	private Thread thread;
	private boolean isRunning;
	
	//The variables dealing with the frames per second
	private int FPS = 60;
	private long targetTime = 1000/FPS;
	
	//The thing that manages the state the game is in
	//ie. Main menu, map, level, etc...
	private GameStateManager gsm;
	
	//The constructor method
	public GamePanel(){
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		
		setFocusable(true);
		
		new Images();
		
		start();
	}
	
	private void start(){
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		gsm.mouseMoved(e.getX(), e.getY());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		gsm.mouseClicked(e.getX(), e.getY());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		gsm.keyPressed(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		gsm.keyReleased(e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		long start, elapsed, wait;
		
		gsm = new GameStateManager();
		
		while(isRunning){
			start = System.nanoTime();
			
			tick();
			repaint();
			
			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed / 1000000;
			
			if(wait <= 0){
				wait = 5;
			}
			
			try{
				Thread.sleep(wait);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
	
	public void tick(){
		gsm.tick();
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		gsm.draw(g);
	}
}
