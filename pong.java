import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.util.Scanner;

public class Driver extends JPanel implements ActionListener, KeyListener {
	int table_width = 900; //width of the screen "table"
	int table_height = 600;//height of the screen "table"
	
	int radius = 50;
	/*
	 * int bound of rectangle
	 * xmin = wahtever and xmax = whatever
	 * int bound of ball
	 * ballmin = whatever and ballmax == whatever
	 * if xpos is > xmin and < xmax {
	 * change velocity
	 * else
	 * nothing 
	 */
	
	/*
	 * int xmaxb = 10 + x_r
	 * int xminb = 0 + x_r
	 * 
	 * int rmaxb = 2*radius + x
	 * int rminb = 0 + x
	 * 
	 * if( xmaxb - xminb >= rmaxb-rminb)
	 * reverse
	 */
	
	
	int x = 100;
	int y = 100;
	int y_r = 100;
	int x_r = 100;
	
	int bxmin = x_r -5;
	int bxmax = x_r +5;
	int bymax = 25 + y_r;
	int bymin = y_r - 25;
	
	//int min = 0;
	//int max = 2*radius;
	
	double xvelocity = -3;
	double yvelocity = 5;
	int gravity = 10;
	double bxvelocity;
	double byvelocity;
	
	public void paint(Graphics g) {
		
		super.paintComponent(g);
		g.setColor(new Color(0, 0 , 0 ));
		g.fillRect(0, 0, table_width, table_height);
		g.setColor(Color.WHITE);
		g.fillRect(y_r, x_r, 10, 50);
		g.fillOval(x, y, radius, radius);
		
		//g.setColor(Color.RED);
		//g.fillRect(y_r, x_r, 10+x_r, 50 + y_r);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		x += xvelocity;
		y += yvelocity;
		x_r += bxvelocity;
		y_r += byvelocity;
		if(y >= table_height-radius || y <= 0 - radius){
			if(yvelocity < 0)
				yvelocity = -yvelocity;
			else
				yvelocity = -yvelocity;
		}else if(x >= table_width - radius || x<=0 - radius ){
				xvelocity = -xvelocity;
				x = table_width/2;
				y = table_height/2;
		
		}else if(x <= bxmax && bymax >= y && y >= bymin){
			//if(xvelocity < 0){
			//xvelocity = -xvelocity;
			//}
			//else
				xvelocity = -xvelocity;
				System.out.println("x" + x + "y" + y);
		}
		
		
		repaint();
		
	}
	//public void paint_pong1(Graphics )
	
	public static void main(String[] arg) {
		Driver d = new Driver();
		//Scanner input = new Scanner(System.in);
		//x = input.nextInt();
		//y = input.nextInt();
		//input.close();
	}
	public Driver(){
		
		JFrame f = new JFrame(); 	
		f.setTitle("Pong");
		f.setSize(table_width,table_height);
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

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
		int key = e.getKeyCode();
		switch (key){
		case 39:
			bxvelocity = 10;
			break;
		case 37:
			bxvelocity = -10;
			break;
		case 40:
			//y_r += 10;
			break;
		case 38:
			//y_r -= 10;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		switch (key){
		case 39:
			bxvelocity = 0;
			break;
		case 37:
			bxvelocity = 0;
			break;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
