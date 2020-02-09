package view;

import java.awt.Graphics;
import javax.swing.JPanel;

public class ReportTypeCropVsArea extends JPanel{

	private static final long serialVersionUID = 1L;

	public ReportTypeCropVsArea(){
		setOpaque(false);
		setSize(550,700);
		setVisible(true);
	}
	
	public void paint(Graphics g){
		g.drawRect(80, 40, 300, 560);

		g.drawString("0 -100", 20, 580);
		g.drawLine(75, 575, 85, 575);

		g.drawString("100 -200", 10, 550);
		g.drawLine(75, 545, 85, 545);

		g.drawString("200 -300", 10, 520);
		g.drawLine(75, 515, 85, 515);

		g.drawString("300 -400", 10, 490);
		g.drawLine(75, 485, 85, 485);

		g.drawString("400 -500", 10, 460);
		g.drawLine(75, 455, 85, 455);

		g.drawString("500 -600", 10, 430);
		g.drawLine(75, 425, 85, 425);

		g.drawString("700 -800", 10, 400);	
		g.drawLine(75, 395, 85, 395);

		g.drawString("800 -900", 10, 370);
		g.drawLine(75, 365, 85, 365);

		g.drawString("900 -1000", 10, 340);
		g.drawLine(75, 335, 85, 335);

		g.drawString("1000 -2000", 10, 310);	
		g.drawLine(75, 305, 85, 305);

		g.drawString("2000 -3000", 10, 280);	
		g.drawLine(75, 275, 85, 275);

		g.drawString("3000 -4000", 10, 250);
		g.drawLine(75, 245, 85, 245);

		g.drawString("4000 -5000", 10, 220);
		g.drawLine(75, 215, 85, 215);

		g.drawString("5000 -6000", 10, 190);	
		g.drawLine(75, 185, 85, 185);

		g.drawString("6000 -7000", 10, 160);
		g.drawLine(75, 155, 85, 155);

		g.drawString("7000 -8000", 10, 130);
		g.drawLine(75, 125, 85, 125);

		g.drawString("8000 -9000", 10, 100);
		g.drawLine(75, 95, 85, 95);

		g.drawString("9000 -10000", 10, 70);
		g.drawLine(75, 65, 85, 65);

		g.drawRect(100, 290, 40, 310);
		g.drawString("Tomate", 104,615);

		g.drawRect(170, 280, 40, 320);
		g.drawString("Arveja", 174,615);

		g.drawRect(240, 420, 40, 180);
		g.drawString("habichuela", 230,615);

		g.drawRect(310, 415, 40, 185);
		g.drawString("hortalizas", 305,615);

		g.drawString("Tipo Cultivo Verde", 395,195);
		g.drawString("Vs", 440,215);
		g.drawString("Area Siembra", 410,235);
	}
}