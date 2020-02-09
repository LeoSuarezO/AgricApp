package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import constants.ConstantsView;
import general.HandlerLanguage;

public class ConfigButton extends JButton{

	private static final long serialVersionUID = 1L;

	public void buttonImage(String path, Color background, boolean borderPainted) {
		setFocusable(false);
		setBorderPainted(borderPainted);
		setBackground(background);
		setIcon(new ImageIcon(path));
	}

	public void buttonTextIcon(String path, String text, Color background, boolean borderPainted, Font font, Color foreground) {
		setFont(font);
		setBackground(background);
		setForeground(foreground);
		setFocusable(false);
		setBorderPainted(borderPainted);
		setText(HandlerLanguage.languageProperties.getProperty(text));
		if(!path.equals(ConstantsView.NULL)) setIcon(new ImageIcon(path));
	}

	public void txt(String texto, Color color, Color colorTxt) {
		setText(texto);
		setBackground(color);
		setFocusable(false);
		setForeground(colorTxt);
		setBorderPainted(true);
		setBorder(null);
		setForeground(Color.BLACK);
	}
}
