package view;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class ReportConutTypeCultive extends JPanel{

	private static final long serialVersionUID = 1L;

	public ReportConutTypeCultive() {
		this.setName("Cantidad de cultivos por Tipo");
//		setIconImage(new ImageIcon(ConstantsView.LOGO_APP).getImage());
		setSize(750,570);
		setVisible(true);
	}
	
	public void paint(Graphics g){
		g.drawString("Cantidad de Cultivos", 565,195);
		g.drawString("Por", 610,220);
		g.drawString("Tipo de Cultivo", 580,245);
		g.drawString("Cultivo de Verde", 580,325);
		g.drawString("Cultivo de G-Seco", 580,345);
		g.drawString("Cultivo de H-Seca", 580,365);
		g.drawString("Cultivo de Semilla", 580,385);
		g.drawString("Cultivos de Bulbo", 580,405);
		g.drawString("Cultivos de Tuber", 580,425);
		g.drawString("Cultivos de Fruta", 580,445);
		
		g.drawRect(90, 170, 470, 340);

		g.drawString("10", 30, 455);
		g.drawLine(85, 455, 95, 455);

		g.drawString("20", 30, 395);
		g.drawLine(85, 395, 95, 395);

		g.drawString("30", 30, 335);
		g.drawLine(85, 335, 95, 335);

		g.drawString("40", 30, 275);
		g.drawLine(85, 275, 95, 275);

		g.drawString("50", 30, 215);	
		g.drawLine(85, 215, 95, 215);
		
		g.setColor(Color.BLUE);
		g.fillRect(130, 197, 40, 313);
		g.fillOval(570, 337, 7,7);
		
		g.setColor(Color.orange);
		g.fillRect(190, 275, 40, 235);
		g.fillOval(570, 437, 7,7);
		
		g.setColor(Color.PINK);
		g.fillRect(250, 425, 40, 85);
		g.fillOval(570, 357, 7,7);
		
		g.setColor(Color.CYAN);
		g.fillRect(310, 315, 40,195);
		g.fillOval(570, 317, 7,7);
		
		g.setColor(Color.RED);
		g.fillRect(370, 468, 40,43);
		g.fillOval(570, 377, 7,7);
		
		g.setColor(Color.MAGENTA);
		g.fillRect(440, 468, 40,43);
		g.fillOval(570, 397, 7,7);
			
		g.setColor(Color.darkGray);
		g.fillRect(500, 488, 40,23);
		g.fillOval(570, 417, 7,7);
	}
}