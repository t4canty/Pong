import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Enemy {
	private int x, y, vx = 0, vy = 0;
	private String fileName;
	
	public Enemy(String fileName){
		this.fileName = fileName;
		x = 0;
		y = 0;
	}
	
	public Enemy(String fileName, int x, int y){
		this.fileName = fileName;
		this.x = x;
		this.y = y;
	}
	
	public void setVX(int Nx){
		vx = Nx;
	}
	public void setVY(int Ny){
		vy = Ny;
	}
	public void paint(Graphics g) throws IOException{
		x += vx;
		y += vy;
		BufferedImage img = ImageIO.read(new File(fileName));
		g.drawImage(img, x, y, 100, 100, null, null );
	}

}
