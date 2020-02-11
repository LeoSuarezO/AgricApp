package view;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constants.ConstantsView;

public class PanelHomeP extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel img;
	private JLabel date;
	private JLabel text;
	private String path;
	private String dateS;
	private String txt;
	private String descS;
	private JLabel desc;
	private JPanel panel;
	
	public PanelHomeP(String path, String date, String descS, String txt) {
		this.path = path;
		this.txt = txt;
		this.dateS = date;
		this.descS = descS;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.white);
		setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
		init();
	}
		
		public void init() {
			img = new JLabel();
			date = new JLabel();
			text = new JLabel();
			desc = new JLabel();
			panel = new JPanel();
			config();
		}
		
		public void config() {
			img.setIcon(new ImageIcon(path));
			
			date.setFont(ConstantsView.BAUHAUS_15_PLAIN);
			date.setText(dateS);
			date.setBorder(BorderFactory.createEmptyBorder(10, 5, 5, 10));
		
			text.setFont(ConstantsView.BAUHAUS_15_PLAIN);
			text.setText(txt);
			text.setBorder(BorderFactory.createEmptyBorder(10, 5, 15, 10));
			
			desc.setFont(ConstantsView.BAUHAUS_15_PLAIN);
			desc.setText(descS);
			desc.setBorder(BorderFactory.createEmptyBorder(10, 5, 15, 10));
			
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			panel.setBackground(Color.white);
			panel.setBorder(new RoundBorder(10));
			
			panel.add(date);
			panel.add(img);
			panel.add(text);
			panel.add(desc);
			
			add(panel);
		}
}
