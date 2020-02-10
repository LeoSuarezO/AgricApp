package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;

import constants.ConstantsLanguage;
import constants.ConstantsView;
import general.HandlerLanguage;

public class ReportTypeCropVsAreaHarv extends JDialog{

	private static final long serialVersionUID = 1L;
	private ConfigButton accept;
	private JPanel panel;

	public ReportTypeCropVsAreaHarv(){
		setSize(550,700);
		setResizable(false);
		setLayout(new BorderLayout());
		setTitle(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.REP_TYPE_HARV));
		setIconImage(new ImageIcon(ConstantsView.LOGO_APP).getImage());
		setBackground(Color.WHITE);
		setLocationRelativeTo(null);
		setModal(true);
		init();
		setVisible(true);
	}
	
	public void init() {
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(5, 100, 5, 100));
		accept = new ConfigButton();
		accept.buttonTextIcon(ConstantsView.NULL, ConstantsLanguage.ACCEPT, Color.WHITE, true, ConstantsView.BAUHAUS_15_PLAIN, Color.DARK_GRAY);
		panel.add(accept, BorderLayout.SOUTH);
	}
	
	public void changeLanguage() {
		
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

		g.drawLine(80, 600, 105, 295);
		g.drawLine(105, 295,170,275);
		g.drawLine(170, 275,250,420);
		g.drawLine(250, 420,320,427);

		g.setColor(Color.YELLOW);
		g.fillOval(105, 295, 7,7);
		g.fillOval(400, 285, 7,7);

		g.setColor(Color.CYAN);
		g.fillOval(170, 275, 7,7);
		g.fillOval(400, 315, 7,7);

		g.setColor(Color.GRAY);
		g.fillOval(250, 420, 7,7);
		g.fillOval(400, 255, 7,7);

		g.setColor(Color.RED);
		g.fillOval(320, 427, 7,7);
		g.fillOval(400, 345, 7,7);

		g.setColor(Color.black);
		g.setFont(ConstantsView.BAUHAUS_15_PLAIN);
		g.drawString("Tipo Cultivo: Verde", 395,125);
		g.drawString("Vs", 440,145);
		g.drawString("Area Cosecha", 410,165);
		g.drawString("hortalizas = 593", 410,265);
		g.drawString("Tomate = 1386", 410,295);
		g.drawString("Arveja = 1650", 410,325);
		g.drawString("habichuela = 507", 410,355);
	}
}