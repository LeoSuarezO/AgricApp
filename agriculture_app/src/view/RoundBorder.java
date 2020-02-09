package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.border.Border;

public class RoundBorder implements Border {

	private int radius;
	private Color color=null;
	private int border=0;

	public RoundBorder(int radius) {
		this.radius = radius;
	}

	public RoundBorder(int radius,Color color, int border) {
		this.radius = radius;
		this.color = color;
		this.border = border;
	}

	public Insets getBorderInsets(Component arg0) {
		return new Insets(this.radius/4, this.radius/4, this.radius/4, this.radius/4);
	}


	public boolean isBorderOpaque() {
		return true;
	}

	public void paintBorder(Component component, Graphics graphic, int x, int y, int width, int height) {
		if (border==0) {
			graphic.drawRoundRect(y, y, width-1, height-1, radius, radius);
		}else if (border ==1) {
			graphic.setColor(color);
			graphic.fillRoundRect(y, y, width-1, height-1, radius, radius);
		}else {
			graphic.setColor(color);
			graphic.fillRoundRect(y, y, width-1, height-1, radius, radius);
			graphic.setColor(Color.black);
			graphic.drawRoundRect(y, y, width-1, height-1, radius, radius);
		}
	}
}