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
	
	
	int x = table_width/2;
	int y = table_height/2;
	int y_b = table_height /2;
	int x_r = 100;
	int y2_b = table_height / 2;
	int x2_r = table_width - 100;
	
	int bxmin = x_r -5;
	int bxmax = x_r +5;
	int bymax = 25 + y_b;
	int bymin = y_b - 25;
	
	
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
		g.fillRect(x_r, y_b, 10, 50);
		g.fillOval(x, y, radius, radius);
		g.fillRect(x2_r, y2_b , 10, 50);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		x += xvelocity;
		y += yvelocity;
		//x_r += bxvelocity;
		y_b += byvelocity;
		y2_b += b2yvelocity
		if(y >= table_height-radius || y <= 0 - radius){
			if(yvelocity < 0)
				yvelocity = -yvelocity;
			else
				yvelocity = -yvelocity;
		}else if(x >= table_width - radius || x<=0 - radius ){
				xvelocity = -xvelocity;
				x = table_width/2;
				y = table_height/2;
		
		}
		
		
		bxmin = x_r -5;
		bxmax = x_r +5;
		bymax = 25 + y_b;
		bymin = y_b - 25;

		if(x <= bxmax && y <= bymax && y >= bymin){
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
		case 40:
			if (y_b < table_height)
				byvelocity = 10;
			break;
		case 38:
			if (y_b > 0)
				byvelocity = -10;
			break;
		case 39:
			//y_b += 10;
			break;
		case 37:
			//y_b -= 10;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		switch (key){
		case 40:
			byvelocity = 0;
			break;
		case 38:
			byvelocity = 0;
			break;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
