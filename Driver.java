import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Driver extends JPanel implements ActionListener, KeyListener {
		Frog pFrog = new Frog("C://Users//1844478//workspace//Frogger//src//1062463.png");
		Enemy enemyList[] = new Enemy[20];
		for(int i = 0; i < enemyList.length -1; i++){
			enemyList[i] = new Enemy("C:\Users\1844478\workspace\Frogger\src\kissclipart-red-blood-cell-clipart-red-blood-cell-73843139f1142862.jpg")
		}
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int table_width = (int) screenSize.getWidth(), table_height = (int) screenSize.getHeight();
		
	
	public static void main(String[] arg){
		Driver d = new Driver();
	}
	
	public Driver(){
		JFrame f = new JFrame();
		f.setTitle("Arrays");
		f.setSize(table_width, table_height);
		f.setBackground(Color.BLACK);
		f.setResizable(false);
		f.addKeyListener(this);
		f.add(this);
		
		
		t = new Timer(17,this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	Timer t;
	
	
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.drawRect(0, 0, table_width, table_height);
		
		try {
			pFrog.paint(g);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(){
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		update();
		repaint();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		case 38:
			pFrog.setVY(-10);
			break;
		case 40:
			pFrog.setVY(10);
			break;
		case 37:
			pFrog.setVX(-10);
			break;
		case 39:
			pFrog.setVX(10);
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()){
		case 38:
			pFrog.setVY(0);
			break;
		case 40:
			pFrog.setVY(0);
			break;
		case 37:
			pFrog.setVX(0);
			break;
		case 39:
			pFrog.setVX(0);
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
