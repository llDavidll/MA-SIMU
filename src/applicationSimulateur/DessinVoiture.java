package applicationSimulateur;

import java.awt.Graphics;

import javax.swing.JFrame;

public class DessinVoiture extends JFrame {

	public static final int TailleFenetreEnPixels = 500;
	
	private int xPixelVoiture;
	private int yPixelVoiture;
	
	public DessinVoiture() {
		super();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setTitle("Simulateur de Voiture");
		this.setSize(TailleFenetreEnPixels, TailleFenetreEnPixels);
		this.setVisible(true);
		this.xPixelVoiture = 0;
		this.yPixelVoiture = 480;
	}

	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		dessinerVoiture(graphics);

	}

	public void dessinerVoiture(Graphics graphics) {
		int[] xPoints = {xPixelVoiture,xPixelVoiture,xPixelVoiture+20};
		int[] yPoints = {yPixelVoiture - 10,yPixelVoiture + 10,yPixelVoiture};
		graphics.fillPolygon(xPoints, yPoints, 3);
	}

	public void setXPixelVoiture(int xPixelVoiture) {
		this.xPixelVoiture = xPixelVoiture;
	}

	public void setYPixelVoiture(int yPixelVoiture) {
		this.yPixelVoiture = yPixelVoiture;
	}

}
