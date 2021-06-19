import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Block extends Rectangle {
	
	Image picture;
	boolean isBlockDestroyed;
	
	int moveX;
	int moveY;
		
	Block(int x, int y, int w, int h, String s) {
		this.x = x;
		this.y = y;
		
		moveX = 3;
		moveY = 3;
		
		this.width = w;
		this.height = h;
		
		try {
			picture = ImageIO.read(new File("src/" + s));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void draw(Graphics g, Component c) {
		if(!isBlockDestroyed) {
			g.drawImage(picture, x, y, width, height, c);
		}
		
	}

}
