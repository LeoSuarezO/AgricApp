package view;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import constants.ConstantsView;

public class PanelHome extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelHomeP one;
	private PanelHomeP two;
	private PanelHomeP three;

	public PanelHome() {
		setLayout(new BorderLayout());
		setBackground(ConstantsView.GREEN);
		setBorder(BorderFactory.createEmptyBorder(30, 30, 40, 30));
		init();
	}
	
	public void init() {
		one = new PanelHomeP(ConstantsView.ONE, "viernes, 7 de febrero de 2020",
				"<html><body>Gracias al presidente Duque y a Colombia por la oportunidad <br>de servirle al campo y aportar a su transformación<br>: ministro Andrés Valencia</html></body>", "<html><body>En la estrategia Coseche y Venda a la Fija se lograron 38.000 productores conectados <br>con negocios por $622.000 millones.<html><body>");
		two = new PanelHomeP(ConstantsView.TWO, "martes, 4 de febrero de 2020", "\n" + 
				"<html><body>El ICA convoca a concurso de mérito público y abierto <br>para la elección de gerentes seccionales<html><body>", "<html><body>las inscripciones para participar en la <br>convocatoria se realizarán únicamente el día 7 de febrero de 2020</html></body>");
		three = new PanelHomeP(ConstantsView.THREE, "jueves, 6 de febrero de 2020", "\r\n" + 
				"<html><body>Con diplomacia sanitaria, recuperamos el estatus sanitario de país <br>libre de fiebre aftosa con vacunación: MinAgricultura</html></body>", "#DiplomaciSanitaria");
		config();
	}
	
	public void config() {
		add(one);
		add(two);
		add(three);
	}

}
